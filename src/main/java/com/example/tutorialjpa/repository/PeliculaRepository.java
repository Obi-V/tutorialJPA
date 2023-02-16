package com.example.tutorialjpa.repository;

import com.example.tutorialjpa.domain.Pelicula;
import com.example.tutorialjpa.domain.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository  extends JpaRepository<Pelicula,Long> {

}
