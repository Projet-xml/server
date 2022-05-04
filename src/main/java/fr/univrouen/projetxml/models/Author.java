package fr.univrouen.projetxml.models;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@Entity
@XmlRootElement(name = "author")
@XmlAccessorType(XmlAccessType.NONE)
@Table(name = "author")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name ="author_id")
    private int id;

    @XmlElement
    @JacksonXmlProperty(localName = "name")
    private String name;

    @XmlElement
    @JacksonXmlProperty(localName = "email")
    private String email;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> item;

    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Author() { }

    public String getName() {
        return name;
    }
}
