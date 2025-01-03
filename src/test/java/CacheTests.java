import Cache.CacheReplacementPolicy;
import Cache.Cache;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CacheTests {

    @Test
    void lru_HeadUpdatesOnGet(){
        Cache<String, String> cache = new Cache<String, String>(8, CacheReplacementPolicy.LRU);
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.get("2");
        assertEquals("2", cache.getHead().getKey());
    }

    @Test
    void lru_onCapacityReachedRemoveLru(){
        Cache<String, String> cache = new Cache(2, CacheReplacementPolicy.LRU);
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");

        assertNull(cache.get("1"));
    }

    @Test
    void mru_HeadUpdatesOnGet(){
        Cache<String, String> cache = new Cache<String, String>(8, CacheReplacementPolicy.MRU);
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.get("2");

        assertEquals("2", cache.getHead().getKey());
    }

    @Test
    void mru_onCapacityReachedRemoveMru(){
        Cache<String, String> cache = new Cache(2, CacheReplacementPolicy.MRU);
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");

        assertNull(cache.get("2"));
    }


}
