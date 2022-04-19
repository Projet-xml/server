package fr.univrouen.projetxml.controllers;

import fr.univrouen.projetxml.models.Item;
import fr.univrouen.projetxml.services.GetService;
import fr.univrouen.projetxml.utils.FileLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GetController {

    @Autowired
   // private final GetService getService;

    public GetController() {
    }

    @GetMapping("/")
    @ResponseBody
    public String index() {
       return FileLoader.loadFile("classpath:templates/index.html");
        //return "hello";
        //return "index";
    }

    @GetMapping("/help")
    @ResponseBody
    public String help() {
        return FileLoader.loadFile("classpath:templates/help.html");
    }

   /* @RequestMapping(value = "rss/resume/xml",method = RequestMethod.GET,  produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody
    ResponseEntity<List<Item>> getXML() {
        List<Item> items = getService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);

    }*/
}
