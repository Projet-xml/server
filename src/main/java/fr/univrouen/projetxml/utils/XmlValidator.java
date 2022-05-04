package fr.univrouen.projetxml.utils;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;

import org.springframework.core.io.Resource;

public class XmlValidator {

    public static boolean validateXMLSchema(String flux) throws IOException {

        Resource resource = new DefaultResourceLoader()
                .getResource("classpath:static/xml/filetovalidate.xml");

        File fileToValidate = resource.getFile();

        try (PrintWriter file = new PrintWriter(fileToValidate)) {
            file.println(flux);
        }

        Resource resource1 = new DefaultResourceLoader()
                .getResource("classpath:static/xml/valid.xsd");

        File xsdSchema = resource1.getFile();

        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdSchema);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(fileToValidate));

        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());

            return false;
        }
        return true;
    }



}
