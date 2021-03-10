package com.inacioalves.PersonApi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.inacioalves.PersonApi.dto.PersonDto;
import com.inacioalves.PersonApi.entity.Person;



@Mapper
public interface PersonMaper {
	
    PersonMaper INSTANCE =Mappers.getMapper(PersonMaper.class);

    
	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
	Person toMdel(PersonDto personDto);
	
	PersonDto toDTO(Person person);

}
