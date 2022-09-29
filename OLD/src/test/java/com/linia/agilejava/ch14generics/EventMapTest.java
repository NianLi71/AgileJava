package com.linia.agilejava.ch14generics;

import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EventMapTest {
    @Test
    public void testSingleElement() {
        EventMap<java.sql.Date, String> map = new EventMap<>();

        final java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());

        final String value = "abc";

        map.put(date, value);

        List<String> values = map.get(date);
        assertEquals(value, values.get(0));
    }

    @Test
    public void testGetPastEvents() {
        EventMap<Date, String> events = new EventMap<>();

        final Date today = new Date();
        final Date yesterday = new Date(today.getTime() - 86400000);

        events.put(today, "sleep");

        final String desA = "birthday";
        final String desB = "drink";

        events.put(yesterday, desA);
        events.put(yesterday,desB);

        List<String> des = events.getPastEvents();

        assertTrue(des.contains(desA));
        assertTrue(des.contains(desB));
    }
}
