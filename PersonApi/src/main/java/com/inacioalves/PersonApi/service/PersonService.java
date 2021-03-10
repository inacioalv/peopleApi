package com.inacioalves.PersonApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inacioalves.PersonApi.dto.MessageResponseDto;
import com.inacioalves.PersonApi.entity.Person;
import com.inacioalves.PersonApi.repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personrepository;

	@Autowired
	public PersonService(PersonRepository personrepository) {
		this.personrepository = personrepository;
	}
	
	 public MessageResponseDto createPerson(Person person) {
	        Person personToSave = personrepository.save(person);

	        return MessageResponseDto
	        		.builder()
	        		.message("Created person with ID"+personToSave.getId())
	        		.build();
	    }
	
	

}
