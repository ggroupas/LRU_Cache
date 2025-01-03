import Cache.CacheReplacementPolicy;
import Cache.Cache;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LruCacheTests {

    /**
     * Test that the head updates when a node is accessed
     * */
    @Test
    void headUpdatesOnGetTest(){
        Cache<String, String> cache = new Cache<String, String>(8, CacheReplacementPolicy.LRU);
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.get("2");
        assertEquals("2", cache.getHead().getKey());
    }

    /**
     * Test that tail gets removed when capacity is reached
     * */
    @Test
    void onCapacityReachedRemoveLruTest(){
        Cache<String, String> cache = new Cache(2, CacheReplacementPolicy.LRU);
        cache.put("1", "1");
        System.out.println(cache);
        cache.put("2", "2");
        System.out.println(cache);

        cache.put("3", "3");
        System.out.println(cache);

        cache.get("2");
        assertEquals("3", cache.getTail().getKey());
        assertEquals("2", cache.getHead().getKey());
        assertNull(cache.get("1"));
    }
}
