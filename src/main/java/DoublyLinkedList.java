
/*
 * previous: closer to tail
 * next: closer to head
 *
 * head: most recently used
 * tail: least recently used
 * */
public class DoublyLinkedList<K, V> {


    static class Node<K, V>{
        K key;
        V value;
        Node<K, V> previous;
        Node<K, V> next;

        public Node(K key, V data) {
            this.key = key;
            this.value = data;
        }
    }

    Node<K, V> head = null;
    Node<K, V> tail = null;

    public void addNode(K key, V value) {
        Node<K, V> newNode = new Node<>(key, value);

        addNode(newNode);
    }

    public void addNode(Node<K, V> newNode) {

        if (isEmpty()) {
            //Both head and tail will point to newNode
            head = tail = newNode;
            head.next = null;
            head.previous = null;
        }
        else if (head == tail) { //Only one element in the list
            tail = head;
            tail.next = newNode;
            head = newNode;
            head.previous = tail;
        } else {
            head.next = newNode;
            newNode.previous = head;
            head = newNode;
        }
    }

    public void remove(Node<K, V> node) {

        if (node == tail){
            node.next.previous = null;
            tail = node.next;
        } else if (node == head){
            node.previous.next = null;
            head = node.previous;
        } else {
            node.next.previous = node.previous;
            node.previous.next = node.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void moveToHead(Node<K, V> node) {
        if (node == head) {
            return;
        }

        if (node == tail) {
            tail = node.next;
        }

        head.next = node;
        node.previous = head;
        head = node;
    }

    public void removeTail() {
        this.remove(tail);
    }

    public Node<K, V> getHead() {
        return head;
    }

    @Override
    public String toString() {
        Node<K, V> current = head;
        StringBuilder returnString = new StringBuilder();
        while (current != null) {
            returnString.append("KEY:").append(current.key.toString()).append(" VALUE:").append(current.value.toString()).append("\n");
            current = current.previous;
        }

        return returnString.toString();
    }
}