package com.example.tutorialjpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(of={"id"})

@Entity
@Table(
        name="socio",
        schema="bbdd_tutoriales"
)
public class Socio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name ="dni")
    private String dni;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name= "apellidos")
    private String apellidos;

    @OneToOne(mappedBy = "socio", cascade = CascadeType.ALL)
    private Tarjeta tarjeta;

}
