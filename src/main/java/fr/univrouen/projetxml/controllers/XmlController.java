package fr.univrouen.projetxml.controllers;

import fr.univrouen.projetxml.models.Item;
import fr.univrouen.projetxml.models.feed;
import fr.univrouen.projetxml.services.GetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public feed getXML() {
        List<Item> items = getService.getAllItems();
        return new feed(items);

    }

    @GetMapping(value = "/rss22/resume/xml/{id}",  produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody Item getXML1(@PathVariable int id) {
        Item item = getService.getItemById(id);
        return new Item(item.getGuid(), item.getTitle(), item.getPublished(), item.getUpdated(),item.getContent(), item.getAuthor(),item.getContributor());
    }

}
