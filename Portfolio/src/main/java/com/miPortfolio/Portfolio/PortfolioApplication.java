package com.miPortfolio.Portfolio;


import com.miPortfolio.Portfolio.Entity.Persona;
import com.miPortfolio.Portfolio.Repository.IPersonaRepository;
import com.miPortfolio.Portfolio.Security.Entity.Rol;
import com.miPortfolio.Portfolio.Security.Entity.Roles;
import com.miPortfolio.Portfolio.Security.Entity.Usuario;
import com.miPortfolio.Portfolio.Security.Payload.request.SignupRequest;
import com.miPortfolio.Portfolio.Security.Repository.RolRepository;
import com.miPortfolio.Portfolio.Security.Repository.UsuarioRepository;
import com.miPortfolio.Portfolio.Service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class PortfolioApplication {



	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

	//context llena la base de datos si esta vacia
	@Bean
	public CommandLineRunner context(RolRepository rolRepository, IPersonaRepository personaRepository, UsuarioRepository usuarioRepository)
	{
		return args -> {
			if(personaRepository.findAll().isEmpty())
			{
						Persona yo = new Persona("Lucas","Caceres"
												,"Soy una persona proactiva que busca aplicar sus conocimientos"
												,"FullStack Trainee");
						personaRepository.save(yo);
			}

			if(rolRepository.findAll().isEmpty())
			{
				Rol admin = new Rol(Roles.ROLE_ADMIN);
				Rol usuario = new Rol(Roles.ROLE_USER);
				rolRepository.save(admin);
				rolRepository.save(usuario);
			}
			if(usuarioRepository.findAll().isEmpty()) {
				RestTemplate restTemplate = new RestTemplate();
				Set<String> rolesAdmin = new HashSet<>();
				rolesAdmin.add("admin");
				rolesAdmin.add("usuario");
				Set<String> rolesUsuario = new HashSet<>();
				rolesUsuario.add("usuario");
				SignupRequest signupRequestAdmin = new SignupRequest("admin", rolesAdmin, "admin");
				SignupRequest signupRequestUsuario = new SignupRequest("usuario", rolesUsuario, "usuario");
				URI locationAdmin = restTemplate.postForLocation("http://localhost:8080/api/auth/signup"
																,signupRequestAdmin
																,SignupRequest.class);
				URI locationUser = restTemplate.postForLocation("http://localhost:8080/api/auth/signup",signupRequestUsuario,SignupRequest.class);
			}
		};


	}






}
