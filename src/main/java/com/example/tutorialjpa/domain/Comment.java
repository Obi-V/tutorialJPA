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
        name="comments",
        schema="bbdd_tutoriales"
)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_id")
    private long id;

    @Column(name="content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_tutorial", nullable= false, foreignKey = @ForeignKey(name ="FK_TUTORIAL"))

    //Para romper el bucle de la relacion bidireccional
    @JsonIgnore
    @ToString.Exclude
    private Tutorial tutorial;

}
