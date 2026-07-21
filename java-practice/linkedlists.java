class LinkedListPractice {
    public static void main(String[] args) {
        
    }
}

class LinkedList  {
    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public LinkedList(int data) {
        this.head = new Node(data);
        this.size = 1;
    }

    public int size() {
        return this.size;
    }

    public boolean empty() {
        return this.size == 0;
    }

    public int value_at(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public void push_front(int data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }

    public int pop_front() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }

        int data = this.head.data;
        this.head = this.head.next;
        this.size--;

        return data;
    }

    public void push_back(int data) {
        Node newNode = new Node(data);

        if (this.size == 0) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }

    public int pop_back() {
        if (this.size == 0) {
            throw new IllegalStateException("List is empty");
        }

        if (this.size == 1) {
            int value = this.head.data;
            this.head = null;
            this.size--;
            return value;
        }

        Node current = this.head;
        while (current.next.next != null) {
            current = current.next;
        }
        int value = current.next.data;
        current.next = null;
        this.size--;
        return value;
    }

    public int front() {
        if (this.size == 0) {
            throw new IllegalStateException("List is empty");
        }
        return this.head.data;
    }

    public int back() {
        if (this.size == 0) {
            throw new IllegalStateException("List is empty");
        }

        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    public void insert(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            push_front(value);
            return;
        }

        Node newNode = new Node(value);
        Node current = this.head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        this.size++;
    }

    public void erase(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            pop_front();
            return;
        }

        Node current = this.head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        current.next = current.next.next;
        this.size--;
    }

    public int value_n_from_end(int n) {
        if (n < 1 || n > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        n = size - n;
        Node current = this.head;
        for (int i = 0; i < n; i++) {
            current = current.next;
        }

        return current.data;
    }

    public void reverse() {
        if (size <= 1) {
            return;
        }

        Node prev = null;
        Node current = this.head;

        while (current.next != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        this.head = current;
    }

    public void remove_value(int value) {
        Node current = this.head;
        for (int i = 0; i < size; i++) {
            if (current.data == value) {
                this.erase(i);
                return;
            }
            current = current.next;
        }
    }
}
