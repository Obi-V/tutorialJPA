package com.example.tutorialjpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(of={"id"})

@Entity
@Table(
        name="tarjeta",
        schema="bbdd_tutoriales"
)
public class Tarjeta {
    @Id
    //GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarjeta")
    private long id;

    //@Pattern(regexp = "^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$")
    @Column(length = 16)
    private String numero;

    //@Pattern(regexp = "^(0[1-9]|1[0-2])\\/?([0-9]{2})$")
    @Column(length = 5)
    private String caducidad;

    @OneToOne
    @JoinColumn(/* name = "id_socio"*/ name = "id_tarjeta", foreignKey = @ForeignKey(name= "FK_SOCIO"))
    @MapsId
    @JsonIgnore
    @ToString.Exclude
    private Socio socio;
}
