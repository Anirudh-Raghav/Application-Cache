/*
    Abstraction is done using GENERICS by using the key (either an int, long or even a String) & Value to be a parameter to the
 */

/**
 * Creates a cache entity which can be stored in local memory for easy & faster accessing.
 * @param <K> class for the key
 * @param <V> class for the value to be stored in the entity
 */
public class CacheNode<K, V> {
    private K key;
    private V value;

    // Constructor
    public CacheNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Getters
    public V getValue() {
        return value;
    }
    public K getKey() {
        return key;
    }

    // Setters
    public void setValue(V newValue) {
        value = newValue;
    }
    public void setKey(K newKey) {
        key = newKey;
    }
}