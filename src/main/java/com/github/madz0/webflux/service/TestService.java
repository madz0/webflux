package com.github.madz0.webflux.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.madz0.webflux.model.Person;

import reactor.core.publisher.Flux;

/**
 * @author Mohamad Zeinali
 *
 * Mar 10, 2018
 */
@RestController
@RequestMapping("/api")
public interface TestService {

	@RequestMapping("/test")
	Flux<Person> test();
}
