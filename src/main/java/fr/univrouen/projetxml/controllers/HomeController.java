package fr.univrouen.projetxml.controllers;

import fr.univrouen.projetxml.utils.FileLoader;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/help")
    @ResponseBody
    public String help() {
        return FileLoader.loadFile("classpath:templates/help.html");
    }

    @GetMapping("/")
    @ResponseBody
    public String home() {
       return FileLoader.loadFile("classpath:templates/home.html");
        //return "hello";
        //return "home";
    }




}
