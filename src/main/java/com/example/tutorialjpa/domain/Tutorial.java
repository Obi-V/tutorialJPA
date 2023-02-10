package com.example.tutorialjpa.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

//Lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(
        name="tutorial",
        schema="bbdd_tutoriales",
        indexes={@Index(name = "title_index", columnList="title", unique= true)}
)
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_tutorial")
    private Long id;

    @Column(name="title", nullable = false,length = 150)
    public String title;

   @Column(name = "description")
   private String description;

   @Column(name= "published")
   private boolean published;

   @OneToMany(mappedBy = "tutorial", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @OnDelete(action = OnDeleteAction.CASCADE)
   private List<Comment> comments = new ArrayList<>();
}
