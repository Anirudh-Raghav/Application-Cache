public class CacheManager<K, V> extends UserDAO{

    private static final int CAPACITY = 5;
    private LRUCache cache;

    public CacheManager() {
        cache = new LRUCache(CAPACITY);
    }

    public V readOne(K id) {
        V entity = (V) cache.get(id);
        if (entity == null) {
            // fetch from the database

            // And add it to the cache (if it exists in the DB) by uncommenting the below line
            // cache.put(id, newEntity);
        }
        // Returns null if it doesn't exist in the DB
        return entity;
    }
    public V update(K id) {
        // First check if the entity exists
        V currentEntity = readOne(id);
        if (currentEntity == null) {
            return null;
        }

        // Update it and obtain updated value from DB.
        // We can check in the backend if the given id exists
        // Uncomment to modify the cache

        // cache.modify(id, newEntity);
        return currentEntity;
    }

    public void delete(K id) {
        // Delete from the DB

        cache.remove(id);
    }

}
