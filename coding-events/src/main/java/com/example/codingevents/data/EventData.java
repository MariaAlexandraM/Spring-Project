package com.example.codingevents.data;

import com.example.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {

    // we need a place to put events
    private static final Map<Integer, Event> events = new HashMap<>();

    // our app should b able to:

    // get all events,
    public static Collection<Event> getAllEvents() {
        return events.values();
    }
    // a single event,
    public static Event getById(int id) {
        return events.get(id);
    }
    // add an event,
    public static void add(Event event) {
        events.put(event.getId(), event);
    }
    // delete an event
    public static void remove(int id) {
        events.remove(id);
    }


}
