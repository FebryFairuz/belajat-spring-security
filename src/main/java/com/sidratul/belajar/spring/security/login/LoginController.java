package com.sidratul.belajar.spring.security.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        
        UserDetails us  = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String namaus = us.getUsername();        
        
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName(); //get logged in username
        

        model.addAttribute("username", name);
        model.addAttribute("namalain", namaus);
        model.addAttribute("message", "Spring Security login + database example");
        return "index";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public void login(ModelMap model) {
        
    }

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
            return "login";
    }
}