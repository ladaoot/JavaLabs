package lab6;

public class Stack<T> {

    private final static int DEFAULT_CAPACITY=10;
    private T[] data;
    private int size;

    public Stack(){
        this.data=(T[]) new Object[DEFAULT_CAPACITY];
        this.size=0;
    }

    public void push(T element) {
        if(size==data.length){
            T[] newData =(T[]) new Object[size*10];

            for (int i = 0; i < size; i++) {
                newData[i]=data[i];
            }
            this.data=newData;
        }
        this.data[size]=element;
        size++;
    }
    public T pop() {
        if(size==0){
            return null;
        }
        T el = data[size-1];
        size--;
        return el;
    }
    public T peek() {
        if(size==0){
            return null;
        }
        return data[size-1];
    }
}
