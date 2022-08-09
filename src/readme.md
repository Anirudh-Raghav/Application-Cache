# Caching system

We use LRU based entity caching. This works on prioritizing the most recently accessed data.

## Data structures used

1. Deque (on a double-linked list) - This is used to keep track of the most recently accessed data entities
    > In case of *Least Frequently used* paradigm for storing in a cache, we can change this to a **Priority Queue** 
     and use the number of clicks/hits as the weight of each node
2. HashMap - This is used to store the data and access it in O(1). It might take more than O(1) in case of clashes in 
3. hashing although this is quite unlikely

## CacheNode functionality

1. `get` operation - This is used to obtain the data entity from the cache in case 
it exists in it. This runs in **O(n)** as searching on a double linked list takes O(n) because only linear search can be 
done 
2. `put` operation - This is used to write a data entity in the cache. This runs in **O(1)** time as it inserts it into 
   the starting of the queue.
3. `modify` operation - This is used to modify a data entry given a key. This takes **O(n)** time because it also performs
    a linear search for finding the entry in the queue.
4. `flush` operation - This returns an `ArrayList` of all the cache entities in the cache. This takes **O(n)** time to go 
    through all the entries in the queue and removes all of them in O(1) time. 

> Note: n here refers to the max length of the queue used to store the cache.

## 
