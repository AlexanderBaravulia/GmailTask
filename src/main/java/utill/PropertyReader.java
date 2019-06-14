package utill;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static final String CONFIG_PATH = "src" + File.separator + "main" + File.separator + "resources"
            + File.separator + "config.properties";

    private static String getValue(String pathToProperty, String key){
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream(pathToProperty);
            property.load(fis);
            return property.getProperty(key);
        } catch (IOException e) {
            System.err.println("Error to get property by the key : " + key);
            return null;
        }
    }

    public static String getConfigValue(String key){
        return getValue(CONFIG_PATH, key);
    }

}
