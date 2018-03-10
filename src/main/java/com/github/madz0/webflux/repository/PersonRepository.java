package com.github.madz0.webflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.github.madz0.webflux.model.Person;

/**
 * @author Mohamad Zeinali
 *
 * Mar 10, 2018
 */
@Repository
public interface PersonRepository extends ReactiveCrudRepository<Person, Long> {

}
