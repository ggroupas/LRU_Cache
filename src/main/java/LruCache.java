import javax.swing.*;
import java.util.HashMap;

public class LruCache<K, V> extends Cache<K, V> {

    LruCache(int capacity) {
        super(capacity);
    }

    @Override
    public V get(K key) {
        if (!_map.containsKey(key)) {
            _misses++;
            return null;
        }

        _hits++;
        DoublyLinkedList.Node<K, V> node = _map.get(key);
        _list.moveToHead(node);

        return node.value;
    }

    @Override
    public void put(K key, V value) {
        if (_map.containsKey(key)) {
            _list.moveToHead(_map.get(key));
            return;
        }

        var newNode = new DoublyLinkedList.Node<>(key, value);
        if (_map.size() >= _capacity) {
            _map.remove(_list.tail.key);
            _list.removeTail();
        }

        _list.addNode(newNode);
        _map.put(key, newNode);
    }
}