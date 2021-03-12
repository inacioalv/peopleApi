package com.inacioalves.PersonApi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inacioalves.PersonApi.dto.MessageResponseDto;
import com.inacioalves.PersonApi.dto.PersonDto;
import com.inacioalves.PersonApi.exeption.PersonNotFoundExeption;
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
	 public MessageResponseDto createPerson(@RequestBody @Valid PersonDto personDto) {
	        return personservice.createPerson(personDto);
	    }
	 
	 @GetMapping
	 public List<PersonDto>listAll(){
		return personservice.listall();
	 }
	
	 @GetMapping("/{id}")
	 public PersonDto findById(@PathVariable Long id) throws PersonNotFoundExeption {
		 return personservice.findById(id);
	 }
	 
	 @PutMapping("/{id}")
	 public MessageResponseDto updateById(@PathVariable Long id,@RequestBody  PersonDto personDto) throws PersonNotFoundExeption {
		 return personservice.updateById(id,personDto);
	 }
	
	 @DeleteMapping("/{id}")
	 @ResponseStatus(code = HttpStatus.NO_CONTENT)
	 public void deleteById(@PathVariable  Long id) throws PersonNotFoundExeption {
		 personservice.deleteById(id);
		 
	 }
}
