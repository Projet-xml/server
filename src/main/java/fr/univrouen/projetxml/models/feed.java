package fr.univrouen.projetxml.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "feed")
@XmlAccessorType(XmlAccessType.NONE)
public class feed {


    @XmlElement
    private List<Item> items;

    public feed(List<Item> items) {
        this.items = items;
    }

    public feed() {}


}
