package br.com.intelipost.user.details.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.intelipost.user.details.document.UserDetailsIntelipost;
import br.com.intelipost.user.details.endpoint.UserDetailsIntellipostEndpoint;

@Controller
public class HomeController {
	
	@Autowired
	private UserDetailsIntellipostEndpoint userEndpoint;

	@RequestMapping("/dashboard")
	public String home(Model model){
    	ResponseEntity<UserDetailsIntelipost> userDetails = userEndpoint.getDetails(1L);
    	model.addAttribute("userDetails", userDetails.getBody());
		return "dashboard";
	}
}
