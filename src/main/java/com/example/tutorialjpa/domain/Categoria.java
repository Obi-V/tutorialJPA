package com.example.tutorialjpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_categoria;

    @Column
    private String nombre;

    @Column
    private Date ultima_actualizacion;

    @ManyToMany(
            mappedBy = "categorias")
    @JsonIgnore
    Set<Pelicula> peliculas = new HashSet<>();
}
