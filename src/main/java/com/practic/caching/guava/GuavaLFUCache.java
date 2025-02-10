package com.practic.caching.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GuavaLFUCache<K, V> {
    private final int capacity;
    private final Cache<K, V> cache;
    private final Map<K, Integer> frequencies;
    private final Map<Integer, LinkedHashSet<K>> frequencyList;
    private int minFrequency;

    public GuavaLFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = CacheBuilder.newBuilder()
                .expireAfterAccess(10, TimeUnit.MINUTES)
                .build();
        this.frequencies = new HashMap<>();
        this.frequencyList = new HashMap<>();
        this.minFrequency = 0;
    }

    public V get(K key) {
        if (!cache.asMap().containsKey(key)) {
            return null;
        }
        updateFrequency(key);
        return cache.getIfPresent(key);
    }

    public void put(K key, V value) {
        if (capacity <= 0) {
            return;
        }

        if (cache.asMap().containsKey(key)) {
            cache.put(key, value);
            updateFrequency(key);
            return;
        }

        if (cache.size() >= capacity) {
            evictLFU();
        }

        cache.put(key, value);
        frequencies.put(key, 1);

       /* LinkedHashSet<K> values = frequencyList.get(1);
        if(Objects.isNull(values)){
            values = new LinkedHashSet<>();
        }
        values.add(key);*/
        frequencyList.computeIfAbsent(1, Z -> new LinkedHashSet<>()).add(key);
        minFrequency = 1;
    }

    private void updateFrequency(K key) {
        int frequency = frequencies.get(key);
        frequencies.put(key, frequency + 1);
        frequencyList.get(frequency).remove(key); //removing that key from set of values

        if (frequencyList.get(frequency).isEmpty()) {
            frequencyList.remove(frequency);
            if (minFrequency == frequency) {
                minFrequency++;
            }
        }

        frequencyList.computeIfAbsent(frequency + 1,  Z -> new LinkedHashSet<>()).add(key);
    }

    private void evictLFU() {
        K evict = frequencyList.get(minFrequency).iterator().next();
        frequencyList.get(minFrequency).remove(evict);
        if (frequencyList.get(minFrequency).isEmpty()) {
            frequencyList.remove(minFrequency);
        }
        cache.invalidate(evict);
        frequencies.remove(evict);
    }

    public static void main(String[] args) {
        GuavaLFUCache<Integer, String> lfuCache = new GuavaLFUCache<>(3);

        lfuCache.put(1, "one");
        lfuCache.put(2, "two");
        lfuCache.put(3, "three");
        System.out.println("Cache after adding 1, 2, 3: " + lfuCache.cache.asMap());

        // Access key 1
        lfuCache.get(1);
        lfuCache.get(1);
        lfuCache.get(2);
        System.out.println("Cache after accessing 1 twice and 2 once: " + lfuCache.cache.asMap());

        // Add another element, which should evict the least frequently used (key 3)
        lfuCache.put(4, "four");
        System.out.println("Cache after adding key 4 (should evict key 3): " + lfuCache.cache.asMap());

        lfuCache.get(4);
        lfuCache.get(4);
        lfuCache.get(2);
        lfuCache.put(5, "five");
        System.out.println("Cache after adding key 5 (should evict key 2): " + lfuCache.cache.asMap());
    }
}
