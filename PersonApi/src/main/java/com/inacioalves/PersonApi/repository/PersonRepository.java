package com.inacioalves.PersonApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inacioalves.PersonApi.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
