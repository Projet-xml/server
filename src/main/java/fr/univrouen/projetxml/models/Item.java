package fr.univrouen.projetxml.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.persistence.*;


@Entity
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.NONE)
@Table(name = "item")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;

    @XmlAttribute
    private String guid;

    @XmlElement
    private String title;

    @XmlElement
    private String published;

    @XmlElement
    private String updated;

    @XmlElement
    private String content;
    @XmlElement
    private String author;
    @XmlElement
    private String contributor;




    public Item(String guid, String title, String published,String updated, String content,
                String author, String contributor) {
        super();
        this.guid = guid;
        this.title = title;
        this.published = published;
        this.author = author;
        this.content = content;
        this.contributor = contributor;
        this.updated = updated;
    }

    public Item() {
    }

    @Override
    public String toString() {
        return ("Article : " + title + "\n(" + guid
                + ") Le = " + (published != null ? published : updated) + "\n Écrit par : "
                + (author != null ? author : contributor) + "\n Le contenu : \n" + content );
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

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

}