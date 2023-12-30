package lab8;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try (DataManager dataManager = new DataManager()) {
            dataManager.registerDataProcessor(new RemoveSpaceProcessor());
            dataManager.registerDataProcessor(new RepeatProcessor());
            dataManager.registerDataProcessor(new RepeatProcessor());
            dataManager.registerDataProcessor(new LengthProcessor());
            dataManager.registerDataProcessor(new CharProcessor());

            dataManager.loadData("input.txt");
            dataManager.processData();
            dataManager.saveData("output.txt");
        }
    }
}