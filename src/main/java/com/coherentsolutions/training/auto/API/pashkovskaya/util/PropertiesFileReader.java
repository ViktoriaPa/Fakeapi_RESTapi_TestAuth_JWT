package com.coherentsolutions.training.auto.API.pashkovskaya.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileReader {
    private static Properties prop;
    private static final String PROPERTIES_PATH = "src/main/resources/properties";

    private PropertiesFileReader() {
        setPropsCache();
    }

    private static void setPropsCache() {
        try (InputStream input = new FileInputStream(PROPERTIES_PATH)) {
            prop = new Properties();
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getBaseURI() {
        setPropsCache();
        String baseURI = prop.getProperty("baseURI");
        return baseURI;
    }

    public static String getEmail() {
        setPropsCache();
        String email = prop.getProperty("email");
        return email;
    }

    public static String getPassword() {
        setPropsCache();
        String password = prop.getProperty("password");
        return password;
    }

    public static String getFilePath() {
        setPropsCache();
        String filePath = prop.getProperty("filePath");
        return filePath;
    }

    public static String getFileName() {
        setPropsCache();
        String fileName = prop.getProperty("fileName");
        return fileName;
    }
}
