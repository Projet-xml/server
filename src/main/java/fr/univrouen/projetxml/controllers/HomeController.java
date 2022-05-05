package fr.univrouen.projetxml.controllers;

import fr.univrouen.projetxml.utils.FileLoader;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    @GetMapping("/help")
    @ResponseBody
    public ModelAndView help() {
        return new ModelAndView("help");
    }

    @GetMapping("/")
    @ResponseBody
    public ModelAndView home() {
       return new ModelAndView("home");
        //return "hello";
        //return "home";
    }
}
