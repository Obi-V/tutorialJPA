package com.example.tutorialjpa.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Embeddable
public class Address {

    private long id_address;

    private String city;

    private long houseNumber;

    private String street;

    private long zip_code;

    /*
    * @ManyToOne(fetch= FetchType.LAZY)
    * //@JoinColumn(name = "id_persona")
    * @ToString.Exclude
    * private Person person;
    *
    * */
}
