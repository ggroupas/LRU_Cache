import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LruCacheTests {

    /**
     * Test that the head updates when a node is accessed
     * */
    @Test
    void headUpdatesOnGetTest(){
        LruCache<String, String> cache = new LruCache<>(8);
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.get("2");
        assertEquals("2", cache.getHead().key);
    }

    /**
     * Test that tail gets removed when capacity is reached
     * */
    @Test
    void onCapacityReachedRemoveLruTest(){
        LruCache<String, String> cache = new LruCache<>(2);
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.get("2");
        assertEquals("2", cache.getHead().key);
        assertEquals("3", cache.getTail().key);
        assertEquals(null, cache.get("1"));
    }
}
