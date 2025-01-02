public class CacheFactory<K, V> {

    public static <K, V> Cache<K, V> create(CacheReplacementPolicy replacementPolicy, int capacity) {
        return switch (replacementPolicy) {
            case LRU -> new LruCache<K, V>(capacity);
            case MRU -> new MruCache<K,V>(capacity);
            case LFU -> throw new UnsupportedOperationException();
            default -> throw new IllegalArgumentException("Policy not recognized");
        };
    }
}
