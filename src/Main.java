public class Main {
    public static void main(String[] args) {

        System.out.println("Example run of caching:\n-----------------------");

        // Checking for basic strings
        int capacity = 3;
        LRUCache<Integer, String> cache = new LRUCache<Integer, String>(capacity);

        cache.put(1, "User 1");
        cache.put(2, "User 2");
        cache.put(3, "User 3");
        cache.put(4, "User 4");

        System.out.println(cache.get(1)); // Should print null
        System.out.println(cache.get(4)); // Should print "User 4"

        cache.put(5, "User 5");
        // This should remove "User 3" and add "User 5" in place
        System.out.println(cache.get(2)); // Should print null

        cache.modify(5, "User A");

        System.out.println(cache.get(5));  // Should print "User A"

        cache.remove(5);
        System.out.println(cache.get(5)); // Should print null


        System.out.println("-----------------------");
        // Checking for a pre-built User class

        LRUCache<Integer, User> userCache = new LRUCache<Integer, User>(capacity);
        User user1, user2, user3, user4, user5;

        user1 = new User(1, "A", "Z", "az@gmail.com");
        user2 = new User(2, "B", "Y", "by@gmail.com");
        user3 = new User(3, "C", "X", "cx@gmail.com");
        user4 = new User(4, "D", "W", "dw@gmail.com");

        userCache.put(user1.getId(), user1);
        userCache.put(user2.getId(), user2);
        userCache.put(user3.getId(), user3);
        userCache.put(user4.getId(), user4);

        System.out.println(userCache.get(1)); // Should print null
        userCache.get(4).printDetails(); // Should print details of user 3

        user5 = new User(5, "E", "V", "ev@gmail.com");

        userCache.put(user5.getId(), user5); // Should replace user 3
        System.out.println(userCache.get(2));; // Should print null

        userCache.modify(5, new User(user5.getId(), user5.getFirstName(), user5.getLastName(), "fu@gmail.com"));

        userCache.get(5).printDetails(); // Should print details of user 5

        userCache.remove(5);
        System.out.println(userCache.get(5)); // Should print null

    }
}