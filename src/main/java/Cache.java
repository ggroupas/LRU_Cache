import java.util.HashMap;

public abstract class Cache<K, V>{

    protected final int _capacity;

    protected int _hits = 0;
    protected int _misses = 0;

    protected HashMap<K, DoublyLinkedList.Node<K, V>> _map = new HashMap<>();
    protected DoublyLinkedList<K, V> _list = new DoublyLinkedList<>();

    public Cache(int capacity) {
        _capacity = capacity;
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
    abstract V get(K key);

    /**
     * Put a new key value pair in the cache
     *
     * @param key   the key
     * @param value the value
     */
    abstract void put(K key, V value);

    protected abstract void adjustCapacity();

    protected boolean isMaxCapacityReached() {
        return _map.size() >= _capacity;
    }

    protected void adjustCapacityIfNecessary() {
        if (isMaxCapacityReached()) {
            adjustCapacity();
        }
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
        System.out.println("HEAD " + _list.head.key.toString());
        System.out.println("TAIL " + _list.tail.key.toString());
        return super.toString();
    }
}
