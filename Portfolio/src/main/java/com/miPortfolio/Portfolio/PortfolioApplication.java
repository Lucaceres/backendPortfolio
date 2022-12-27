package com.miPortfolio.Portfolio;


import com.miPortfolio.Portfolio.Entity.Persona;
import com.miPortfolio.Portfolio.Repository.IPersonaRepository;
import com.miPortfolio.Portfolio.Security.Entity.Rol;
import com.miPortfolio.Portfolio.Security.Entity.Roles;
import com.miPortfolio.Portfolio.Security.Repository.RolRepository;
import com.miPortfolio.Portfolio.Service.PersonaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

	@Bean
	public CommandLineRunner roles(RolRepository rolRepository, IPersonaRepository personaRepository)
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
		};
	}




}
