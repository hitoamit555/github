package com.hackerrank.github.services.implementations;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.repository.EventRepository;
import com.hackerrank.github.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl extends GithubService implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public void deleteAll() {
		eventRepository.deleteAll();
	}

	@Override
	public Long addNewEvent(Event event) {
		Event newEvent = eventRepository.save(event);
		return newEvent.getId();
	}
	
	
	@Override
	public List<Event> getAllEvents() {
			
		return GithubService.toList(eventRepository.findAll());
	}

	@Override
	public List<Event> getAllEvents(long actorID) {
		
		return GithubService.toList(eventRepository.findByActorIdOrderByIdAsc(actorID));
		
	}	
}
