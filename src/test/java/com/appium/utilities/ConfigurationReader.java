package com.appium.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.text.MessageFormat;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();

    static {
        try{
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            file.close();
        }catch (IOException e){
            throw new RuntimeException();
        }
    }

    public static String getProperty(String key){
        if(properties.getProperty(key) == null) {
            throw new NullPointerException(MessageFormat.format("Key {0} does not exist or value is null", key));
        }
        return properties.getProperty(key);
    }
}
