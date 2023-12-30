package lab8;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class DataManager implements Closeable{

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);;
    private List<Processor> processors = new ArrayList<>();
    private List<Object> values;

    public void registerDataProcessor(Object processor){
        Method[] methods = processor.getClass().getMethods();
        for (Method method : methods){
            if (method.isAnnotationPresent(DataProcessor.class)){
                processors.add(new Processor(processor, method));
            }
        }
    }


    public void processData(){
        values = values.stream()
                .map(value -> executorService.submit(() -> processValue(value)))
                .collect(Collectors.toList()).stream()
                .map(this::getFutureValue)
                .collect(Collectors.toList());
    }

    public void loadData(String source) {
        values = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line = reader.readLine();
            while (line != null){
                values.add(line);
                line = reader.readLine();
            }
        } catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    public void saveData(String destination){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))){
            for (Object value : values){
                writer.write(value.toString());
                writer.newLine();
            }
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
    }

    private Object getFutureValue(Future<Object> future){
            try {
                return future.get();
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
    }

    private Object processValue(Object value) {
        for (Processor processor: processors){
            try {
                value = processor.getMethod().invoke(processor.getObject(), value);
            } catch (InvocationTargetException | IllegalAccessException ex){
                throw new RuntimeException(ex);
            }
        }
        return value;
    }

    @Override
    public void close() throws IOException {
        executorService.shutdown();
    }

    private static class Processor{
        private Object object;
        private Method method;

        public Processor(Object object, Method method){
            this.object = object;
            this.method = method;
        }

        public Object getObject() {
            return object;
        }

        public Method getMethod() {
            return method;
        }
    }
}
