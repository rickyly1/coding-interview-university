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

    private int hash(int key, int capacity) {
        return Math.abs(key % capacity);
    }

    public void add(int key, int value) {
        Entry newEntry = new Entry(key, value);
        int hash = this.hash(key, this.capacity);

        while (dictionary[hash] != null && dictionary[hash].key != key && !dictionary[hash].deleted) {
            hash = (hash + 1) % this.capacity;
        }

        if (dictionary[hash] == null || dictionary[hash].deleted) {
            this.size++;
        }
        
        dictionary[hash] = newEntry;

        if ((this.size * 2) >= this.capacity) {
            this.capacity *= 2;
            Entry[] oldDictionary = this.dictionary;
            this.dictionary = new Entry[this.capacity];
            this.size = 0;

            for (Entry entry : oldDictionary) {
                if (entry != null && !entry.deleted) {
                    this.add(entry.key, entry.value);
                }
            }
        }
    }

    public boolean exists(int key) {
        int index = this.hash(key, this.capacity);
        while (this.dictionary[index] != null) {
            if (!this.dictionary[index].deleted && this.dictionary[index].key == key) {
                return true;
            }
            index = (index + 1) % this.capacity;
        }

        return false;
    }

    public Entry get(int key) {
        int index = this.hash(key, this.capacity);
        while (this.dictionary[index] != null) {
            if (!this.dictionary[index].deleted && this.dictionary[index].key == key) {
                return this.dictionary[index];
            }
            index = (index + 1) % this.capacity;
        }

        return null;
    }

    public void remove(int key) {
        int index = this.hash(key, this.capacity);
        while (this.dictionary[index] != null) {
            if (!this.dictionary[index].deleted && this.dictionary[index].key == key) {
                this.dictionary[index].deleted = true;
                this.size--;

                if ((this.size) * 4 <= this.capacity) {
                    this.capacity /= 2;
                    Entry[] oldDictionary = this.dictionary;
                    this.dictionary = new Entry[this.capacity];
                    this.size = 0;

                    for (Entry entry : oldDictionary) {
                        if (entry != null && !entry.deleted) {
                            this.add(entry.key, entry.value);
                        }
                    }
                }

                return;
            }
            index = (index + 1) % this.capacity;
        }
    }
}
