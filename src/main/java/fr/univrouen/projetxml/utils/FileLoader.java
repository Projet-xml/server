package fr.univrouen.projetxml.utils;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileLoader {

    public static String loadFile(String filePath) {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(filePath);
        try {
            return asString(resource);
        } catch (IOException e) {
            return "An error occured : " + e.toString();
        }
    }

    public static String asString(Resource resource) throws IOException  {
        try (Reader reader = new InputStreamReader(resource.getInputStream()))
        {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            return "An error occured : " + e.toString();
        }
    }

}
