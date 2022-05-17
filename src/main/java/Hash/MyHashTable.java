package Hash;

import java.util.Arrays;

public class MyHashTable {

    private final Item[] data;
    private final int capacity;
    private int size;
    private static final Item AVAILABLE = new Item("Available", null);

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        data = new Item[capacity];
        Arrays.fill(data, AVAILABLE);
        size = 0;
    }

    public int size() {
        return size;
    }

    public int hashThis(String key) {
        return key.hashCode() % capacity;
    }

    public Object get(Object key) {

        int hash = hashThis(key.toString());

        while (data[hash] != AVAILABLE && data[hash].key() != key) {

            hash = (hash + 1) % capacity;
        }
        return data[hash].element();
    }

    public void put(Object key, Object element) {

        if (key != null) {
            size++;
            int hash = hashThis(key.toString());
            while (data[hash] != AVAILABLE && data[hash].key() != key) {

                hash = (hash + 1) % capacity;
            }

            data[hash] = new Item(key.toString(), element);

        }

    }

    public void remove(Object key) {
        int hash = hashThis(key.toString());
        data[hash] = AVAILABLE;
        size--;
    }

    public String toString() {
        String s = "<HashTable[";
        for (int i = 0; i < this.capacity; i++) {
            if (data[i].element() != null) {
                s += data[i].toString();
                if (i < this.size - 1) {
                    s += ",";
                }
            }
        }
        s += "]>";
        return s;
    }

}