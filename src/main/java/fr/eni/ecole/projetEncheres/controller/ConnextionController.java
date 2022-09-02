package fr.eni.ecole.projetEncheres.controller;

import java.util.Locale;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import fr.eni.ecole.projetEncheres.bo.Utilisateur;

@Controller 
@SessionAttributes(names = { "userInSession" }) 

public class ConnextionController {
	private static Logger logger = Logger.getLogger("ConnexionController"); 
	@ModelAttribute("userInSession") 

	public Utilisateur addMyBean1ToSessionScope() { 

	logger.warning("Injection de l'attribut en session"); 

	return new Utilisateur(); 

	} 

	 

	@RequestMapping(value = "/", method = RequestMethod.GET) 

	public String connecterUtilisateur() { 

	return "login"; 

	} 

	 

	@RequestMapping(value = "/connexion", method = RequestMethod.POST) 

	public String verfiConnectionUtilisateur(@ModelAttribute("userInSession") Utilisateur user) { 

	logger.warning("Voici les données saisies par le client : " + user); 

	 

	return "welcome"; 

	} 

	 

	@RequestMapping(value = "/deconnexion", method = RequestMethod.GET) 

	public String deconnecterUtilisateur(SessionStatus status){ 

	        status.setComplete();		 

	return "redirect:/";
}
	
	@Autowired
	private SessionLocaleResolver localeResolver;



	@RequestMapping(value = "/i18n", method = RequestMethod.GET)



	public String choixDelaLangue(String lg) {
	    Locale locale = new Locale(lg);
	    localeResolver.setDefaultLocale(locale);
	    return "login";
	}
}
