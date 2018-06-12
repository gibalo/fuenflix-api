package es.cesfuencarral.fuenflixapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "es.cesfuencarral.fuenflixapi")
//@PropertySources({ @PropertySource("classpath:application.properties"), @PropertySource("classpath:auth0.properties") })
public class FuenflixApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuenflixApiApplication.class, args);
	}
}
