package fr.univrouen.projetxml.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "feed")
@XmlAccessorType(XmlAccessType.NONE)
public class Feed {


    @XmlElement
    private List<Item> items;

    public Feed(List<Item> items) {
        this.items = items;
    }

    public Feed() {}

    public Item getItem(int index) {
        return items.get(index);
    }


}
