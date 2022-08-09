import java.util.*;

/**
 * Caching based on the LRU format where it gives higher importance to the most recently accessed memory
 * @param <K>  Class used for the key (for example, int, long or a String). Generally a unique ID
 * @param <V>  Class used to denote what is stored in the cache (for example, User)
 */
public class LRUCache<K, V> {
    private final int CAPACITY;
    private Map<K, CacheNode> hashMap;
    private LinkedList<K> list;

    // Constructor
    public LRUCache(int capacity) {
        CAPACITY = capacity;
        hashMap = new HashMap<>();
        list = new LinkedList<K>();
    }

    // Utility functions
    private void enQueue(K key) {
        list.addFirst(key);
    }

    private K deQueue() {
        return list.removeLast();
    }

    private int getSize() {
        return list.size();
    }

    // Used for debugging
    private String queueToString() {
        return list.toString();
    }

    /**
     * Used to get the value of a cache entity for given key from local storage
     * @param key is the key for the value in the hashMap
     * @return value of the cache entity from the hashMap
     */
    public V get(K key) {
        // Checking if the entity exists in the hashMap
        if(!hashMap.containsKey(key)) {
            return null;
        }
        CacheNode entity = (CacheNode) hashMap.get(key);

        list.remove(key);
        enQueue(key);

        return (V) entity.getValue();
    }

    /**
     * Used to insert a cache entity in local storage
     * @param key key used for the hashMap
     * @param value of class V that is to be stored in the caching system
     */

    public void put(K key, V value) {
        CacheNode newEntity = new CacheNode(key, value);

        // Handling the case of a value already present with the same key
        if(hashMap.containsKey(key)) {
            list.remove(key);
        }
        else {
            // Handling the case when the list if full
            if (getSize() >= CAPACITY) {
                K temp = deQueue();
                hashMap.remove(temp);
            }
        }

        // Adding the new cache entity onto the caching system
        enQueue(key);
        hashMap.put(key, newEntity);
    }

    /**
     * Updating the existing value of a cache
     * @param key key for the existing cache entity
     * @param newValue updated value for the cache entity
     */
    public void modify(K key, V newValue) {
        remove(key);
        put(key, newValue);
    }

    /**
     * Focibly deleting a specific cache entity
     * @param key key to the cache entity to be deleted
     * @return Value assigned in the deleted key
     */

    public V remove(K key) {
        if (hashMap.containsKey(key)) {
            list.remove(key);
            V value = (V) hashMap.get(key).getValue();
            hashMap.remove(key);
            return value;
        }
        return null;
    }

    /**
     * Removes all the cache entities in the local storage and returns it as an array
     *
     * @return array of all values in order of most recently used first
     * @// FIXME: 27/05/2022 error at line 96:29 - Type parameter 'V' cannot be instantiated directly (Used ArrayList as a temp fix)
     */
    public ArrayList<V> flush() {
        ArrayList<V> flushedCaches;
        flushedCaches = new ArrayList<V>(CAPACITY);

        for (K key : list) {
            if (hashMap.containsKey(key)) {
                flushedCaches.add((V) hashMap.get(key).getValue());
                hashMap.remove(key);
            }
        }
        list.clear();

        return flushedCaches;
    }
}