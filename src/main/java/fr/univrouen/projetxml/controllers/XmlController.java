package fr.univrouen.projetxml.controllers;

import fr.univrouen.projetxml.models.Item;
import fr.univrouen.projetxml.models.Feed;
import fr.univrouen.projetxml.services.GetService;
import fr.univrouen.projetxml.utils.XmlParser;
import fr.univrouen.projetxml.utils.XmlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class XmlController {

    @Autowired
    private final GetService getService;

    public XmlController(GetService getService) {
        this.getService = getService;
    }


    @GetMapping(value = "/rss22/resume/xml",  produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public List<Item> getAllitems() {
        List<Item> items = getService.getAllItems();
        return items;
    }

    @GetMapping(value = "/rss22/xml")
    @ResponseBody
    public List<Item> getAllitemsJson() {
        List<Item> items = getService.getAllItems();
        return items;
    }

    @GetMapping(value = "/rss22/resume/xml/{id}",  produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody Item getItemById(@PathVariable int id) {
        Item item = getService.getItemById(id);
        return new Item(item.getGuid(), item.getTitle(), item.getPublished(), item.getUpdated(),item.getContent(), item.getAuthor());
    }


    @GetMapping(value = "/rss22/xml/{id}")
    public @ResponseBody Item getItemByIdJson(@PathVariable int id) {
        Item item = getService.getItemById(id);
        return new Item(item.getGuid(), item.getTitle(), item.getPublished(), item.getUpdated(),item.getContent(), item.getAuthor());
    }


    @PostMapping(value = "/rss22/insert", consumes = "application/xml",  produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public Item addFlux(@RequestBody String flux) throws IOException {
        if(XmlValidator.validateXMLSchema(flux)) {
            System.out.println("done");
            return getService.addItem(XmlParser.parseToItem(flux));
        }else {
            System.out.println("failed");
            return null;
        }
    }

    @DeleteMapping(value= "/rss22/delete/{id}")
    @ResponseBody
    public int deleteItemById(@PathVariable int id) {
        Item item = getService.getItemById(id);
        getService.deleteItemById(id);
        return id;
    }

}
