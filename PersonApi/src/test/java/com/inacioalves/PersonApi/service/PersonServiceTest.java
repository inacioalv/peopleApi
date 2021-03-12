package com.inacioalves.PersonApi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.inacioalves.PersonApi.PersonUtils.PersonUtils;
import com.inacioalves.PersonApi.dto.MessageResponseDto;
import com.inacioalves.PersonApi.dto.PersonDto;
import com.inacioalves.PersonApi.entity.Person;
import com.inacioalves.PersonApi.repository.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	@Mock
	private PersonRepository personRepository;
	
	@InjectMocks
	private PersonService personService;
	
	@Test
	void testGivenPersonDTOThenReturnSavedMessage() {
		PersonDto personDto =PersonUtils.createFakeDto();
		Person expectedSvedPerson = PersonUtils.createFakeEntity();
		
		Mockito.when(personRepository.save(any(Person.class))).thenReturn(expectedSvedPerson);
		
		MessageResponseDto expectedSuccessMessage = createMessageResponse(expectedSvedPerson.getId());
		
		MessageResponseDto succesMessage =  personService.createPerson(personDto);
		
		assertEquals(expectedSuccessMessage, succesMessage);
	}

	private MessageResponseDto createMessageResponse(Long id) {
		return MessageResponseDto
				.builder()
				.message("Created person with ID"+id)
				.build();
	}

}
