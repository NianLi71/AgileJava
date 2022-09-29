package com.linia.agilejava.ch14generics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionTest {
    @Test
    public void listTest() {
        final String name = "joe";
        List<String> names = new ArrayList<>();
        names.add(name);
        String retrievedName = names.get(0);
        Assert.assertEquals(retrievedName, name);
    }

    @Test
    public void hashMapTest() {
        final String event = "today";
        final Date date = new Date();

        Map<Date, String> events = new HashMap<>();

        events.put(date, event);

        String retrievedEvent = events.get(date);

        Assert.assertEquals(event, retrievedEvent);
    }
}
