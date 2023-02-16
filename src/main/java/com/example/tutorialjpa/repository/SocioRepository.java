package com.example.tutorialjpa.repository;

import com.example.tutorialjpa.domain.Socio;
import com.example.tutorialjpa.domain.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface  SocioRepository  extends JpaRepository<Socio,Long> {

}
