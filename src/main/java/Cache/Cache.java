package Cache;

import DoublyLinkedList.DoublyLinkedList;

import java.util.HashMap;

public class Cache<K, V>{

    protected final int _capacity;
    protected final CacheReplacementPolicy _policy;
    protected final CachePolicyEnforcerBase _policyEnforcer;

    protected int _hits = 0;
    protected int _misses = 0;

    protected HashMap<K, DoublyLinkedList.Node<K, V>> _map = new HashMap<>();

    public Cache(int capacity, CacheReplacementPolicy policy) {
        _capacity = capacity;
        _policy = policy;

        _policyEnforcer = switch (policy) {
            case LRU -> new LruCachePolicyEnforcer();
//            case MRU -> new MruCache<K,V>(capacity);
            case LFU -> throw new UnsupportedOperationException();
            default -> throw new IllegalArgumentException("Policy not recognized");
        };
    }

    public int getHitCount() {
        return _hits;
    }

    public int getMissCount() {
        return _misses;
    }

    /**
     * Get the value for a key. Returns null if the key is not
     * in the cache.
     *
     * @param key the key
     */
    public V get(K key) {
        if (!_map.containsKey(key)) {
            _misses++;
            return null;
        }

        _hits++;
        DoublyLinkedList.Node<K, V> node = _map.get(key);
        _policyEnforcer.onItemAccessed(node);

        return node.getValue();
    }

    /**
     * Put a new key value pair in the cache
     *
     * @param key   the key
     * @param value the value
     */
    public void put(K key, V value) {
        if (_map.containsKey(key)) {
            _policyEnforcer.addExisting(_map.get(key));
            return;
        }

        adjustCapacityIfNecessary();
        var newNode = new DoublyLinkedList.Node<>(key, value);
        _policyEnforcer.add(newNode);
        _map.put(key, newNode);
    }

    public boolean isMaxCapacityReached() {
        return _map.size() >= _capacity;
    }

    protected void adjustCapacityIfNecessary() {
        if (isMaxCapacityReached()) {
            _map.remove(_policyEnforcer.getItemToRemove().getKey());
            _policyEnforcer.onCapacityReached();
        }
    }

    public DoublyLinkedList.Node getHead() {
        return _policyEnforcer.getHead();
    }

    public DoublyLinkedList.Node getTail() {
        return _policyEnforcer.getTail();
    }

    @Override
    public String toString() {
        return _policyEnforcer._list.toString();
    }
}
