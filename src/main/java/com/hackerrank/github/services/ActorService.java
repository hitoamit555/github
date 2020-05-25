package com.hackerrank.github.services;

import com.hackerrank.github.enums.ActorsOrdering;
import com.hackerrank.github.exceptions.ActorNotFoundException;
import com.hackerrank.github.exceptions.ActorUpdateException;
import com.hackerrank.github.model.Actor;

import java.util.List;

public interface ActorService  {

	List<Actor> getAllActors(ActorsOrdering ordering);

	void updateActorAvatar(Actor actor) throws ActorNotFoundException, ActorUpdateException;

}
