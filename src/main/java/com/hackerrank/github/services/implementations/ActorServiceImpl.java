package com.hackerrank.github.services.implementations;

import com.hackerrank.github.enums.ActorsOrdering;
import com.hackerrank.github.exceptions.ActorNotFoundException;
import com.hackerrank.github.exceptions.ActorUpdateException;
import com.hackerrank.github.model.Actor;
import com.hackerrank.github.repository.ActorRepository;
import com.hackerrank.github.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {
	
	@Autowired
	private ActorRepository actorRepository ;

	@Override
	public List<Actor> getAllActors(ActorsOrdering ordering) {
		
		switch(ordering) {
			case NUMBER_OF_EVENTS: return actorRepository.findActorsOrderByNumberEventsDesc();
			case MAXIMUM_STREAK: return actorRepository.findActorsOrderByMaximumStreakDesc();
			default: return actorRepository.findActorsOrderByMaximumStreakDesc();
		}
	}

	@Override
	public void updateActorAvatar(Actor actor) throws ActorNotFoundException, ActorUpdateException {
		
		Actor actorPersisted = actorRepository.findOne(actor.getId());
		
		if(actorPersisted == null) throw new ActorNotFoundException();
		
		if(actor.getLogin() != null && !actor.getLogin().equals(actorPersisted.getLogin())) throw new ActorUpdateException();
		
		actorRepository.save(actor);
		
	}	
}
