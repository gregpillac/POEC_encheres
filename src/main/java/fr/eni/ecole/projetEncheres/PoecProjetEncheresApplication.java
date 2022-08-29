package fr.eni.ecole.projetEncheres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("fr.eni.ecole.projetEncheres.*")
@EntityScan("fr.eni.ecole.projetEncheres.*")
public class PoecProjetEncheresApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoecProjetEncheresApplication.class, args);
	}

}
