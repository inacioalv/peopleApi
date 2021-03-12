package com.inacioalves.PersonApi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inacioalves.PersonApi.dto.MessageResponseDto;
import com.inacioalves.PersonApi.dto.PersonDto;
import com.inacioalves.PersonApi.entity.Person;
import com.inacioalves.PersonApi.exeption.PersonNotFoundExeption;
import com.inacioalves.PersonApi.mapper.PersonMaper;
import com.inacioalves.PersonApi.repository.PersonRepository;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
	
	private PersonRepository personrepository;
	
	private final PersonMaper personMapper = PersonMaper.INSTANCE;

	
	
	 public MessageResponseDto createPerson(PersonDto personDto) {
	        Person personToSave = personMapper.toMdel(personDto);
	        			
	        Person savedPerson = personrepository.save(personToSave);
	        return createMessageResponse(savedPerson.getId(),"Created person with ID");
	    }


	public List<PersonDto> listall() {
		List<Person> allPeople = personrepository.findAll();
		
		return allPeople.stream()
				.map(personMapper::toDTO)
				.collect(Collectors.toList());
	}

	public PersonDto findById(Long id) throws PersonNotFoundExeption {
		Person person =verifyIfExists(id);
		
		return personMapper.toDTO(person);}
	


	public void deleteById(Long id) throws PersonNotFoundExeption {
		verifyIfExists(id);
		
		personrepository.deleteById(id);
	}
	
	
	

	public MessageResponseDto updateById(Long id, PersonDto personDto) throws PersonNotFoundExeption {
		verifyIfExists(id);
		
		Person personToUpdate = personMapper.toMdel(personDto);
		
        Person UpdatePerson = personrepository.save(personToUpdate);
        return createMessageResponse(UpdatePerson.getId(),"Updated person with ID");
        
		
	}
	
	private Person verifyIfExists(Long id) throws PersonNotFoundExeption {
		return personrepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundExeption(id));
	}
	
	
	private MessageResponseDto createMessageResponse(Long id,String message) {
		return MessageResponseDto
				.builder()
				.message(message+id)
				.build();
	}

}
