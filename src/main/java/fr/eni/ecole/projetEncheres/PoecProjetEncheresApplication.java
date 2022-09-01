package fr.eni.ecole.projetEncheres;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("fr.eni.ecole.projetEncheres.*")
@EntityScan("fr.eni.ecole.projetEncheres.*")
public class PoecProjetEncheresApplication {

	public static void main(String[] args) {
		
		Timer t  = new Timer();
		t.schedule(new TimerTask() {

			@Override
			public void run() {
				
				System.out.println("Coucou du timer");
			}
			
		},1000*3600);
		
		
		SpringApplication.run(PoecProjetEncheresApplication.class, args);
	}

}
