package com.github.madz0.webflux.utils;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.madz0.webflux.model.Person;
import com.github.madz0.webflux.repository.PersonRepository;

/**
 * @author Mohamad Zeinali
 *
 * May 1, 2018
 */
@Component
public class Initializer {

	@Autowired
	private PersonRepository personRepository;
	
	@PostConstruct
	public void initialize() {
		
		if(personRepository.count().block() == 0) {
			
			List<Person> persons = new ArrayList<>();
			
			persons.add(new Person() {{
				
				setId(1L);
				setName("test"+getId());
			}});
			persons.add(new Person() {{
				
				setId(2L);
				setName("test"+getId());
			}});
			
			persons.forEach(x->personRepository.save(x));
		}
	}
}
