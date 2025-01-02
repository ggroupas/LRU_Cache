

public class App {
    public static void main(String[] args) {
        LruCache<String, String> cache = new LruCache<>(2);
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.get("2");

    }
}



