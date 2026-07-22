class QueuePractice {
    public static void main(String[] args) {
        
    }
}

class Queue {
    private class Node {
        private int data;
        private Node prev;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Queue(int data) {
        this.head = new Node(data);
        this.tail = head;
        this.size = 1;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (size == 0) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
        }

        this.tail = newNode;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }

        int ans = this.head.data;

        if (size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = head.next;
            this.head.prev = null;
        }
        
        return ans;
    }

    public boolean empty() {
        return this.size == 0;
    }
}
