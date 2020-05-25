package com.hackerrank.github.controller;

import com.hackerrank.github.enums.ActorsOrdering;
import com.hackerrank.github.exceptions.ActorNotFoundException;
import com.hackerrank.github.exceptions.ActorUpdateException;
import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.services.ActorService;
import com.hackerrank.github.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class GithubApiRestController {
    @Autowired
    private EventService eventService;

    @Autowired
    private ActorService actorService;

    @RequestMapping(value = "/erase", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllEvents(HttpServletRequest request) {

        eventService.deleteAll();
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public ResponseEntity<Long> addNewEvent(@RequestBody Event event, HttpServletRequest request) {

        Long eventId = eventService.addNewEvent(event);

        return new ResponseEntity<Long>(eventId, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public ResponseEntity<List<Event>> getAllEvents(HttpServletRequest request) {

        List<Event> events = eventService.getAllEvents();

        return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
    }

    @RequestMapping(value = "/events/actors/{actorID}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Event>> getAllEventsByActorId(@PathVariable("actorID") long actorID, HttpServletRequest request) {

        List<Event> events = eventService.getAllEvents(actorID);

        return new ResponseEntity<List<Event>>( events, HttpStatus.OK);
    }

    @RequestMapping(value = "/actors", method = RequestMethod.PUT)
    public ResponseEntity<Long> updateActorAvatar(@RequestBody Actor actor, HttpServletRequest request) {

        try {

            actorService.updateActorAvatar(actor);

            return new ResponseEntity<Long>( -1L, HttpStatus.OK);

        } catch (ActorNotFoundException e) {
            return new ResponseEntity<Long>( -1L, HttpStatus.NOT_FOUND);
        } catch (ActorUpdateException e) {
            return new ResponseEntity<Long>( -1L, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/actors", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Actor>> getAllActors(HttpServletRequest request) {

        List<Actor> actors = actorService.getAllActors(ActorsOrdering.NUMBER_OF_EVENTS);

        return new ResponseEntity<List<Actor>>(actors, HttpStatus.OK);
    }

    @RequestMapping(value = "/actors/streak", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Actor>> getAllActorsOrderByStreak(HttpServletRequest request) {

        List<Actor> actors = actorService.getAllActors(ActorsOrdering.MAXIMUM_STREAK);

        return new ResponseEntity<List<Actor>>(actors, HttpStatus.OK);
    }


}
