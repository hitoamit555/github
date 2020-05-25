package com.hackerrank.github.repository;

import com.hackerrank.github.model.Event;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EventRepository extends CrudRepository<Event,Long> {

    @Override
    Iterable<Event> findAll();

    List<Event> findByActorIdOrderByIdAsc(long actorID);

    List<Event> findByActorId(int actorID);

    @Transactional
    @Modifying
    @Query("DELETE FROM Event")
    void deleteAll();
}
