package fr.univrouen.projetxml.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.hibernate.annotations.Cascade;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.persistence.*;


@Entity
@XmlRootElement(name = "item", namespace ="http://univrouen.fr/rss22")
@XmlAccessorType(XmlAccessType.NONE)
@Table(name = "item")

public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name ="item_id")
    private int id;

    @XmlAttribute
    private String guid;

    @XmlElement
    @Column(unique = true)
    private String title;

    @XmlElement
    private Date published;

    @XmlElement
    private Date updated;

    @XmlElement
    private String content;

    @XmlElement
    @JoinColumn(name = "author_id")
    @JacksonXmlProperty(localName = "author")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Author author;




    public Item(String guid, String title, Date published,Date updated, String content,
                Author author) {
        super();
        this.guid = guid;
        this.title = title;
        this.published = published;
        this.author = author;
        this.content = content;
        this.updated = updated;
    }

    public Item() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}