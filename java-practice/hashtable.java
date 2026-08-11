class HashTablePractice {
    public static void main(String[] args) {
        
    }
}

class HashTable {
    private class Entry {
        private int key;
        private int value;
        private boolean deleted;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.deleted = false;
        }
    }

    private Entry[] dictionary;
    private int size;
    private int capacity;
    
    public HashTable() {
        this.capacity = 16;
        this.dictionary = new Entry[capacity];
        this.size = 0;
    }
}
