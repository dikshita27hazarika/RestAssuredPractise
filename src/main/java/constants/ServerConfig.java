package constants;

import java.io.FileInputStream;
import java.util.Properties;

public class ServerConfig {

    private static final String HTTP = "http://";
    private static final String HTTPS = "https://";
    public static String SERVER_URL;

    static {
        try {
            Properties properties = new Properties();
            String location = System.getProperty("user.dir") + "/config.properties";
            FileInputStream fi = new FileInputStream(location);
            properties.load(fi);
            SERVER_URL = HTTPS + properties.getProperty("url");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
