package com.linia.agilejava.ch14generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MultiHashMap<K, V> {

    private final Map<K, List<V>> map;

    public MultiHashMap() {
        map = new HashMap<>();
    }

    public long size() {
        return map.size();
    }

    public void put(K key, V value) {
        List<V> values = map.get(key);
        if (Objects.isNull(values)) {
            values = new ArrayList<>();
            map.put(key, values);
        }

        values.add(value);
    }

    public List<V> get(K key) {
        return map.get(key);
    }

    protected Set<Map.Entry<K, List<V>>> entrySet() {
        return map.entrySet();
    }
}
