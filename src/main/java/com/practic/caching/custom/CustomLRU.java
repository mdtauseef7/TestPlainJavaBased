package com.practic.caching.custom;

import java.util.*;


public class CustomLRU{
    public static void main(String[] args) {
        LRUCache<Integer, String> lru = new LRUCache<>(3);
        lru.put(1, "One");
        lru.put(2, "Two");
        lru.put(3, "Three");
        lru.display(); // Output: {1=One, 2=Two, 3=Three}

        lru.get(2); // Access 2 to make it recently used
        lru.put(4, "Four"); // Removes key 1 (Least Recently Used)
        lru.display(); // Output: {3=Three, 2=Two, 4=Four}
    }
}


class LRUCache<K, V> {
    private final int capacity;
    private final LinkedHashMap<K, V> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public V get(K key) {
        return cache.getOrDefault(key, null);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public void display() {
        System.out.println(cache);
    }


}

