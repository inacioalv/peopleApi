package com.inacioalves.PersonApi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inacioalves.PersonApi.dto.MessageResponseDto;
import com.inacioalves.PersonApi.dto.PersonDto;
import com.inacioalves.PersonApi.entity.Person;
import com.inacioalves.PersonApi.mapper.PersonMaper;
import com.inacioalves.PersonApi.repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personrepository;
	
	private final PersonMaper personMapper = PersonMaper.INSTANCE;

	@Autowired
	public PersonService(PersonRepository personrepository) {
		this.personrepository = personrepository;
	}
	
	 public MessageResponseDto createPerson(PersonDto personDto) {
	        Person personToSave = personMapper.toMdel(personDto);
	        			
	        Person savedPerson = personrepository.save(personToSave);
	        return MessageResponseDto
	        		.builder()
	        		.message("Created person with ID"+savedPerson.getId())
	        		.build();
	    }

	public List<PersonDto> listall() {
		List<Person> allPeople = personrepository.findAll();
		
		return allPeople.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	

}
