package com.artefact.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	 @RequestMapping(path="/", method = RequestMethod.GET)
     public String getIndexPage() {
         return "home";
     }
	 
	 @RequestMapping(path="/admin", method = RequestMethod.GET)
     public String getAdminPage() {
         return "admin";
     }

}
