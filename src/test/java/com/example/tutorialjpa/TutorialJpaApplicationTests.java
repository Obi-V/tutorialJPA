package com.example.tutorialjpa;

import com.example.tutorialjpa.domain.*;
import com.example.tutorialjpa.repository.PeliculaRepository;
import com.example.tutorialjpa.repository.SocioRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.tutorialjpa.repository.TutorialRepository;
import com.example.tutorialjpa.repository.SocioRepository;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Period;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

@SpringBootTest
class TutorialJpaApplicationTests {

    @Autowired
    TutorialRepository tutorialRepository;
    @Autowired
    SocioRepository socioRepository;

    @Autowired
    PeliculaRepository peliculaRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testTutorialRepository() {

        Tutorial tutorial1 = Tutorial.builder().title("Tutorial JPA")
                .description("Se describen los aspectos de modelo/entidad con JPA/Hibernate")
                .build();

        tutorialRepository.save(tutorial1);

        List<Tutorial> tutorialList = tutorialRepository.findAll();
        tutorialList.forEach(System.out::println);
    }

    @Test
    void testTutorialWithCommentsRepository() {

        Comment comment1 = Comment.builder().content("El tutorial no está mal, pero hay cosillas que no cuenta").build();
        Comment comment2 = Comment.builder().content("Genial!").build();

        List<Comment> commentList = Arrays.asList(comment1, comment2);

        //Anotacion Lombok @Builder
        Tutorial tutorial1 = Tutorial.builder().title("Tuto2 JPA")
                .description("Otro tuto sobre modelo/entidad con JPA/Hibernate")
                .build();

        Tutorial tutorialSave = tutorialRepository.save(tutorial1);
        //Alternativa tutorialSave


        //Alternativa tutorialFnd recargando la entidad para tener la colección Comments creada
        //Tutorial tutorialFind = tutorialRepository.findById(tutorialSave.getId()).get();

        //Seteamos el tutorial
        commentList.forEach(c -> c.setTutorial(tutorialSave));
        //commentList.forEach( c -> c.setTutorial(tutorialFind));

        tutorialSave.setComments(commentList);
        //tutorialFind.getComments().addAll(commentList);

        // Segunda actualización para actualizar las FK id_tutorial de comentarios nuevos.

        tutorialRepository.save(tutorialSave);
        //tutorialRepository.save(tutorialFind);

        List<Tutorial> tutorialList = tutorialRepository.findAll();
        tutorialList.forEach(System.out::println);

    }

    @Test
    @Order(1)
    void testSocioRepository() {

        Tarjeta tarjeta = Tarjeta.builder()
                .numero("5928283366T")
                .caducidad("05/27")
                .build();

        Socio socio = Socio.builder()
                .dni("029387462")
                .nombre("paco")
                .apellidos("montes")
                .tarjeta(tarjeta)
                .build();

        tarjeta.setSocio(socio);
        socioRepository.save(socio);

        List<Socio> socioList = socioRepository.findAll();
    }

    @Test
    void testSaveOnePelicula() {

        Pelicula pelicula = Pelicula.builder().titulo("Indiana Jones")
                .descripcion("Película para toda la familia de aventura")
                .anyoLanzamiento("1990")
                .idioma("Español")
                .idiomaOriginal("Inglés")
                .duracion(Duration.parse("PT1H40M"))
                .precioAlquiler(new BigDecimal("20.50"))
                .periodoAlquiler(Period.of(0,1,15))
                .clasificacion(Clasificacion.R)
                .caracteristicasEspecialesStr("Trailers,Commentaries")
                .ultimaModificacion(new Date())
                .build();

        peliculaRepository.save(pelicula);

        List<Pelicula> peliculaList = peliculaRepository.findAll();

    }

    @Test
    void testSavePeliculaAndCategoria(){

        Pelicula pelicula = Pelicula.builder()
                .titulo("Indiana Jones")
                .descripcion("Pelicula para toda la familia")
                .anyoLanzamiento("1990")
                .idioma("Español de España")
                .idiomaOriginal("Inglés")
                .duracion(Duration.parse("PT1H40M"))
                .precioAlquiler(new BigDecimal("20.50"))
                .periodoAlquiler(Period.of(0,1,0))
                .clasificacion(Clasificacion.R)
                .caracteristicasEspecialesStr("Trailers,Commentaries")
                .categorias(new HashSet<>())
                .ultimaModificacion(new Date())
                .build();

        String cat = "Aventura";

        Categoria categoria = Categoria.builder()
                .nombre(cat)
                .ultima_actualizacion(new Date())
                .build();

        //NO HACE FALTA SETEAR EN CATEGORÍA EL SET DE PELÍCULA

        peliculaRepository.save(pelicula);

        List<Pelicula> peliculaList = peliculaRepository.findAll();

    }
}