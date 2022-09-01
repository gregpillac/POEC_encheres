package fr.eni.ecole.projetEncheres;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
@EnableJpaRepositories("fr.eni.ecole.projetEncheres.*")
@EntityScan("fr.eni.ecole.projetEncheres.*")
public class PoecProjetEncheresApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoecProjetEncheresApplication.class, args);
	}
	
	@Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
    webServerFactoryCustomizer(){
        return factory -> factory.setContextPath("/POEC_encheres");
    }
    
    @Bean
    public SessionLocaleResolver localeResolver() {
        SessionLocaleResolver r = new SessionLocaleResolver();
        r.setDefaultLocale(Locale.FRANCE);
        return r;    
    }

}
