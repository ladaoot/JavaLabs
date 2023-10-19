package lab3;

import java.util.*;

public class HashTable<K, V> {

    private static final int DEFAULT_SIZE = 8;
    private List<Entry<K, V>>[] entries;
    private int count;

    public HashTable() {
            entries = (List<Entry<K, V>>[]) new List[DEFAULT_SIZE];
            count = 0;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public int size(){
        return count;
    }

    public void remove(K key){
        Entry<K,V> entry = findByKey(key);
        if (entry != null){
            entries[getIndex(key)].remove(entry);
            count--;
        }
    }

    public V get(K key){
        Entry<K,V> entry = findByKey(key);
        return entry == null? null: entry.getValue();
    }

    public void put(K key, V value){
        Entry<K,V> entry = findByKey(key);
        if (entry != null){
            entry.setValue(value);
            return;
        }

        int index = getIndex(key);
        if (entries[index] == null){
            entries[index] = new LinkedList<>();
        }
        entries[index].add(new Entry<>(key, value));
        count++;
    }


    private int getIndex(K key){
        if (key == null){
            throw new UnsupportedOperationException();
        }
        return Math.abs(key.hashCode()) % DEFAULT_SIZE;
    }

    private Entry<K,V> findByKey(K key){
        int index = getIndex(key);
        if (entries[index] == null){
            return null;
        }
        for (Entry<K, V> entry : entries[index]){
            if (entry.getKey().equals(key)){
                return entry;
            }
        }
        return null;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

