import java.util.ArrayList;

class ArraysPractice {
    public static void main(String[] args) {
        
    }
}

class DynamicArray {
    private int[] data;
    private int size;
    private int capacity;

    public DynamicArray() {
        this.capacity = 16;
        this.data = new int[capacity];
        this.size = 0;
    }

    public DynamicArray(int initialCapacity) {
        this.capacity = 16;
        while (this.capacity < initialCapacity) {
            this.capacity *= 2;
        }
        this.data = new int[capacity];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    public boolean is_empty() {
        return this.size == 0;
    }

    public int at(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return this.data[index];
    }

    public void push(int item) {
        if (this.size == this.capacity) {
            this.resize(capacity * 2);
        }

        this.data[size] = item;
        this.size++;
    }

    public void insert(int index, int item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        for (int i = index; i < size; i++) {
            int temp = this.data[i];
            this.data[i] = item;
            item = temp;
        }

        this.size++;
    }

    public void prepend(int item) {
        this.insert(0, item);
    }

    public int pop() {
        if (this.size == 0) {
            throw new IllegalStateException("Array is empty");
        }

        this.size--;

        if (this.size * 4 <= this.capacity) {
            this.resize(this.capacity / 2);
        }

        return this.data[size];
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        for (int i = index; i + 1 < size; i++) {
            this.data[i] = this.data[i + 1];
        }

        this.size--;

        if (this.size * 4 <= this.capacity) {
            this.resize(this.capacity / 2);
        }
    }

    public void remove(int item) {
        for (int i = 0; i < size; i++) {
            if (this.data[i] == item) {
                this.delete(i);
                i--; // Adjust index after deletion
            }
        }
    }

    public int find(int item) {
        for (int i = 0; i < size; i++) {
            if (this.data[i] == item) {
                return i;
            }
        }
        return -1;
    }

    private void resize(int newCapacity) {
        int[] resizedArray = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            resizedArray[i] = this.data[i];
        }
        this.data = resizedArray;
    }
}