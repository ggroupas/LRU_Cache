import javax.swing.*;
import java.util.HashMap;

public class LruCache<K, V> implements ICache<K, V> {

    LruCache(int capacity) {
        _capacity = capacity;
    }

    private final int _capacity;
    private HashMap<K, DoublyLinkedList.Node<K, V>> _map = new HashMap<>();
    private DoublyLinkedList<K, V> _list = new DoublyLinkedList<>();


    @Override
    public V get(K key) {
        if (_map.containsKey(key)) {
            DoublyLinkedList.Node<K, V> node = _map.get(key);
            _list.moveToHead(node);
            return node.value;
        }

        return null;
    }

    @Override
    public void put(K key, V value) {
       if (_map.containsKey(key)){
           this.moveToHead(_map.get(key));
       } else {
              DoublyLinkedList.Node<K, V> newNode = new DoublyLinkedList.Node<>(key, value);
              if (_map.size() >= _capacity) {
                _map.remove(_list.tail.key);
                _list.removeTail();
              }
              _list.addNode(newNode);
              _map.put(key, newNode);
       }
    }

    private void moveToHead(DoublyLinkedList.Node<K,V> kvNode) {
        this._list.moveToHead(kvNode);
    }

    public DoublyLinkedList.Node<K, V> getHead() {
        return _list.head;
    }

    public DoublyLinkedList.Node<K, V> getTail() {
        return _list.tail;
    }

    @Override
    public String toString() {
        System.out.println(_list);
        System.out.println("HEAD "+_list.head.key.toString());
        System.out.println("TAIL "+_list.tail.key.toString());
        return super.toString();
    }
}