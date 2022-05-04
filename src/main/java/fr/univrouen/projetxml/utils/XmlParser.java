package fr.univrouen.projetxml.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import fr.univrouen.projetxml.models.Item;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.net.URL;

public class XmlParser {


    public static Item parseToItem(String flux) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            Item value = xmlMapper.readValue(flux, Item.class);
            return value;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void transform(String xml, String xslt) throws SAXException, IOException,
            ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {

        Resource resource = new DefaultResourceLoader()
                .getResource("classpath:static/xml/filetovalidate.xml");

        File fileToValidate = resource.getFile();

        try (PrintWriter file = new PrintWriter(fileToValidate)) {
            file.println(xml);
        }
        Document xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fileToValidate);
        TransformerFactory transfomerFactory = TransformerFactory.newInstance();
        Transformer transformer = transfomerFactory
                .newTransformer(new StreamSource(XmlParser.class
                        .getResourceAsStream("classpath:static/xml/tp4.xslt")));
        StringWriter stringWriter = new StringWriter();
        transformer.transform(new DOMSource(xmlDocument), new StreamResult(stringWriter));

        // write to file
        File file = new File("classpath:templates/items.html");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(stringWriter.toString());
        bw.close();
    }

    public static void trans(String xml) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer(new StreamSource("classpath:static/xml/tp4.xslt"));
        Resource resource = new DefaultResourceLoader()
                .getResource("classpath:templates/items.html");
        File fileToValidate = resource.getFile();
        transformer.transform(new StreamSource("classpath:static/xml/filetovalidate.xml"), new StreamResult(fileToValidate));
}
}
