package com.example.proyectoEstudiante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProyectoEstudianteApplication {

	/*public static WebMvcConfigurer main(String[] args) {
		SpringApplication.run(ProyectoEstudianteApplication.class, args);

	}*/
	public static void main(String[] args) {
		SpringApplication.run(ProyectoEstudianteApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("*") // Metodos que desea permitir [GET, POST, PUT, DELETE]
						.allowedHeaders("*");
			}
		};
	}

}
