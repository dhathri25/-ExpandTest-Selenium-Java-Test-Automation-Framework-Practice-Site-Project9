
package config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getBrowser() {
        return prop.getProperty("browser");
    }

    public static String getBaseUrl() {
        return prop.getProperty("baseUrl");
    }

    public static int getTimeout() {
        return Integer.parseInt(prop.getProperty("timeout"));
    }
}