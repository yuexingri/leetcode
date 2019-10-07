import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int counter;
    private int capacity;
    private Map<Integer, Integer> cache;
    private Map<Integer, Integer> leastRecentlyUsed;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        counter = 0;
        leastRecentlyUsed = new HashMap<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            counter++;
            leastRecentlyUsed.put(key, counter);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (leastRecentlyUsed.size() == capacity && !leastRecentlyUsed.containsKey(key)) {
            int minKey = 0;
            int minVal = Integer.MAX_VALUE;
            for (int k : leastRecentlyUsed.keySet()) {
                if (minVal > leastRecentlyUsed.get(k)) {
                    minVal = leastRecentlyUsed.get(k);
                    minKey = k;
                }
            }
            cache.remove(minKey);
            leastRecentlyUsed.remove(minKey);
        }

        cache.put(key, value);
        counter++;
        leastRecentlyUsed.put(key, counter);
    }
}
