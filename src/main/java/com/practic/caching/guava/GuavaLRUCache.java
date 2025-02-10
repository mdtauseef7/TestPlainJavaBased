package com.practic.caching.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class GuavaLRUCache<K, V> {
    private final Cache<K, V> cache;

    public GuavaLRUCache(int capacity) {
        this.cache = CacheBuilder.newBuilder()
                .maximumSize(capacity)
                .expireAfterAccess(10, TimeUnit.MINUTES)
                .build();
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public V get(K key) {
        return cache.getIfPresent(key);
    }

    public void invalidate(K key) {
        cache.invalidate(key);
    }

    public long size() {
        return cache.size();
    }

    public static void main(String[] args) {
        GuavaLRUCache<Integer, String> lruCache = new GuavaLRUCache<>(3);

        lruCache.put(1, "one");
        lruCache.put(2, "two");
        lruCache.put(3, "three");
        System.out.println("Cache after adding 1, 2, 3: " + lruCache.cache.asMap());

        // Access key 1
        lruCache.get(2);
        System.out.println("Cache after accessing key 1: " + lruCache.cache.asMap());

        // Add another element, which should evict the least recently used (key 2 or 3)
        lruCache.put(4, "four");
        System.out.println("Cache after adding key 4: " + lruCache.cache.asMap());
    }
}