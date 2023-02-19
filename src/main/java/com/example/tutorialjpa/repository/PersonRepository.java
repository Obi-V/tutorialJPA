package com.example.tutorialjpa.repository;

import com.example.tutorialjpa.domain.Person;
import com.example.tutorialjpa.domain.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person,Long> {

}
