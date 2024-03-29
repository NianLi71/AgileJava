package com.linia.agilejava.ch14generics;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

public class EventMap<K extends java.util.Date, V> extends MultiHashMap<K, V> {
    public List<V> getPastEvents() {
        List<V> events = new ArrayList<>();
        for (Map.Entry<K, List<V>> entry: entrySet()) {
            K date = entry.getKey();
            if (hasPassed(date)) {
                events.addAll(entry.getValue());
            }
        }
        return events;
    }

    private boolean hasPassed(K date) {
        Calendar when = new GregorianCalendar();
        when.setTime(date);
        Calendar today = new GregorianCalendar();

        if (when.get(Calendar.YEAR) != today.get(Calendar.YEAR)) {
            return when.get(Calendar.YEAR) < today.get(Calendar.YEAR);
        }

        return when.get(Calendar.DAY_OF_YEAR) < today.get(Calendar.DAY_OF_YEAR);
    }
}
