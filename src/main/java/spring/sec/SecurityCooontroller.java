package spring.sec;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class SecurityCooontroller {
	/*
	@RequestMapping(value="/login")
	public String login() {
		return "login2";
	}
	*/
	 /*
	@RequestMapping(value="/logout",method= RequestMethod.GET)
	public String logout(HttpSession session) {
		 session.invalidate();
		return "redirect:/login?logout";	
	}*/
	/*
	@RequestMapping("/")
	public String home() {
		return "redirect:/etudiant";
	}
	@RequestMapping("/403")
	public String excep() {
		return "403";
	}
	*/
	/*
	@RequestMapping(value="/login")
	public String login() {
		return "login";	
	}
	
	@RequestMapping("/")
	public String home() {
		return "redirect:suiviepaiement";	
	}
	@RequestMapping("/403")
	public String excep() {
		return "403.html";	
	}
	*/
	/*
	@RequestMapping(value = "login2")
	public String ajoutvideoURL(Model model, Long id) {

		return "login2";
	}
	*/

}
