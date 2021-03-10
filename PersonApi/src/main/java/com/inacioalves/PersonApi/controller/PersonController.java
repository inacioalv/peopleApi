package com.inacioalves.PersonApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inacioalves.PersonApi.dto.MessageResponseDto;
import com.inacioalves.PersonApi.entity.Person;
import com.inacioalves.PersonApi.service.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

	
	private PersonService personservice;

	@Autowired
	public PersonController(PersonService personservice) {
		this.personservice = personservice;
	}
	
	 @PostMapping
	 @ResponseStatus(value = HttpStatus.CREATED)
	 public MessageResponseDto createPerson(@RequestBody  Person person) {
	        return personservice.createPerson(person);
	    }
	
	
}
