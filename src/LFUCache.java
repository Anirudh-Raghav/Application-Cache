import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

public class CacheLFU<K, V> {
    private final int  CAPACITY;
    private Map<K, CacheNode> hashMap;
    private Map<K, Integer> keyWeightMap;
    private PriorityQueue<K> queue;

    public CacheLFU(int capacity) {
        CAPACITY = capacity;
        hashMap = new HashMap<K, CacheNode>();
        keyWeightMap = new HashMap<K, Integer>();
        queue = new PriorityQueue<K>(CAPACITY, (a, b) -> keyWeightMap.get(a) - keyWeightMap.get(b));
    }

    public V get(K key) {
        if (!hashMap.containsKey(key) || !keyWeightMap.containsKey(key)) {
            return null;
        }
        CacheNode node = (CacheNode) hashMap.get(key);


    }

    public boolean put(K key, V value) {
        CacheNode newEntity = new CacheNode(key, value);

        if (hashMap.containsKey(key)) {
            prio
        }
    }

    public boolean modify(K key, V newValue) {
        if (remove(key) != null && put(key, newValue)) {
            return true;
        }
        return false;
    }

    public V remove(K key) {

    }

    public ArrayList<V> flush() {
        ArrayList<V> flushedCaches = new ArrayList<V>(CAPACITY);

        return flushedCaches;
    }
}
