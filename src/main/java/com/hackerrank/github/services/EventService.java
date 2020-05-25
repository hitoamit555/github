package com.hackerrank.github.services;

import com.hackerrank.github.model.Event;

import java.util.List;

public interface EventService {
	
	void deleteAll();

	Long addNewEvent(Event event);

	List<Event> getAllEvents();

	List<Event> getAllEvents(long actorID);
}
