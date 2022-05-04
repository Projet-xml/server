package fr.univrouen.projetxml.controllers;

import fr.univrouen.projetxml.models.Item;
import fr.univrouen.projetxml.services.GetService;
import fr.univrouen.projetxml.utils.FileLoader;
import fr.univrouen.projetxml.utils.XmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class HtmlController {

    @Autowired
    private final GetService getService;

    public HtmlController(GetService getService) {
        this.getService = getService;
    }

    @GetMapping(value = "/rss22/html")
    @ResponseBody
    public ModelAndView getAllItems() throws IOException, ParserConfigurationException, TransformerException, SAXException {
        List<Item> items = getService.getAllItems();
        Map<String, List<Item>> model = new HashMap<String, List<Item>>();
        model.put("watchlistItems", items);
        return new ModelAndView("items", model);
    }

    @GetMapping(value = "/rss22/html/{id}")
    public @ResponseBody ModelAndView getItemById(@PathVariable int id) {
        Item item = getService.getItemById(id);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", item.getId());
        model.put("title", item.getTitle());
        model.put("guid", item.getGuid());
        model.put("published", item.getPublished());
        model.put("updated", item.getUpdated());
        model.put("author", item.getAuthor());
        model.put("content", item.getContent());
        return new ModelAndView("item", model);
    }
}
