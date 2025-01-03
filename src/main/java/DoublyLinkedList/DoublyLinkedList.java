package DoublyLinkedList;

import lombok.Getter;
import lombok.Setter;

/*
 * previous: closer to tail
 * next: closer to head
 *
 * head: most recently used
 * tail: least recently used
 * */
public class DoublyLinkedList<K, V> {

    public static class Node<K, V>{
        @Getter @Setter
        K key;
        @Getter @Setter
        V value;
        @Getter @Setter
        Node<K, V> previous;
        @Getter @Setter
        Node<K, V> next;

        public Node(K key, V data) {
            this.key = key;
            this.value = data;
        }
    }

    @Getter
    Node<K, V> head = null;
    @Getter
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
            tail.next.previous = null;
            tail = tail.next;
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
            tail = tail.next;
            tail.previous = null;

            if (tail.next == null) {
                tail.next = head;
            }
        }

        head.next = node;
        node.previous = head;
        head = node;
        node.next = null;
    }

    public void removeTail() {
        this.remove(tail);
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();

        Node<K, V> current = head;
        while (current != null) {
            returnString.append("KEY:").append(current.getKey().toString()).append(" VALUE:").append(current.getValue().toString()).append("\n");
            current = current.previous;
        }

        return returnString.toString();
    }
}