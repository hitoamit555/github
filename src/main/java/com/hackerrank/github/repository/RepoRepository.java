package com.hackerrank.github.repository;

import com.hackerrank.github.model.Actor;
import org.springframework.data.repository.CrudRepository;

public interface RepoRepository extends CrudRepository<Actor, Long> {
}
