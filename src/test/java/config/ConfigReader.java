package config;

import java.io.FileInputStream;
import java.util.Properties;

/*
 * This class reads data from config.properties file
 */
public class ConfigReader {

    /*
     * This method reads config.properties and returns Properties object
     */
    public Properties readConfig() {

        // Create Properties object
        Properties prop = new Properties();

        try {
            // Give path of config file
            FileInputStream file =
                new FileInputStream("src/test/resources/config/config.properties");

            // Load file into Properties object
            prop.load(file);

        } catch (Exception e) {
            System.out.println("Unable to read config file");
        }

        // Return properties to Hooks class
        return prop;
    }
}
