package com.example.inicial1;

import com.example.inicial1.entities.Autor;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.AutorRepository;
import com.example.inicial1.repositories.BaseRepository;
import com.example.inicial1.repositories.PersonaRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Inicial1Application {
	private static final Logger logger = LoggerFactory.getLogger(Inicial1Application.class);

	@Autowired
	private PersonaRepository personaRepository;
	public static void main(String[] args) {
		SpringApplication.run(Inicial1Application.class, args);

		System.out.println("funcionando el proyecto");
		}
		@Bean
		@Transactional
		CommandLineRunner init(AutorRepository autorRepository,
							   PersonaRepository personaRepository){
		return args -> {
			//Personas
			Persona persona1 = Persona.builder()
					.nombre("Vicente")
					.apellido("Cara Tapia")
					.dni(44909938)
					.build();
			Persona persona2 = Persona.builder()
					.nombre("Valentín")
					.apellido("Becerra")
					.dni(45231231)
					.build();
			Persona persona3 = Persona.builder()
					.nombre("Sofía")
					.apellido("Montes")
					.dni(44982123)
					.build();

			//Autores
			Autor autor1 = Autor.builder()
					.nombre("Miguel")
					.apellido("de Cervantes")
					.biografía("Novelista, poeta, dramaturgo y soldado español, autor de El ingenioso hidalgo don Quijote de la Mancha")
					.build();

			Autor autor2 = Autor.builder()
					.nombre("Edgar Allan")
					.apellido("Poe")
					.biografía("Escritor, poeta, crítico y periodista romántico estadounidense")
					.build();

			// Grabar a través del repositorio de Spring
			personaRepository.save(persona1);
			personaRepository.save(persona2);
			personaRepository.save(persona3);
			autorRepository.save(autor1);
			autorRepository.save(autor2);
		};
		}
	}

