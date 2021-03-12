package com.inacioalves.PersonApi.PersonUtils;

import java.time.LocalDate;
import java.util.Collections;

import com.inacioalves.PersonApi.dto.PersonDto;
import com.inacioalves.PersonApi.entity.Person;

public class PersonUtils {
	
	private static final String FIRST_NAME="Inacio";
	private static final String LAST_NAME="Alves";
	private static final String CPF_NUMBER="369.333.878-79";
	private static final long PERSON_ID=1l;
	private static final LocalDate BIRTH_DATE=LocalDate.of(2021, 3, 1);
	
	
	
	public static PersonDto createFakeDto() {
		return PersonDto.builder()
				.firstName(FIRST_NAME)
				.lastName(LAST_NAME)
				.cpf(CPF_NUMBER)
				.birthDate("04-04-2018")
				.phones(Collections.singletonList(PhoneUtils.createFakeDto()))
				.build();
	}
	
	public static Person createFakeEntity() {
		return Person.builder()
				.id(PERSON_ID)
				.firstName(FIRST_NAME)
				.lastName(LAST_NAME)
				.cpf(CPF_NUMBER)
				.birthDate(BIRTH_DATE)
				.phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
				.build();
	}
	

}
