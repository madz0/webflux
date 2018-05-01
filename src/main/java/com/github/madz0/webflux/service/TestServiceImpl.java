package com.github.madz0.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.madz0.webflux.model.Person;
import com.github.madz0.webflux.repository.PersonRepository;

import reactor.core.publisher.Flux;

/**
 * @author Mohamad Zeinali
 *
 * Mar 10, 2018
 */
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private PersonRepository personRepository;
	/* (non-Javadoc)
	 * @see com.github.madz0.webflux.service.TestService#test()
	 */
	@Override
	public Flux<Person> test() {
		
		return personRepository.findAll();
	}

}
