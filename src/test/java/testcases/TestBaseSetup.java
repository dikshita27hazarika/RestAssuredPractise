package testcases;

import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBaseSetup {
    public static Properties properties;

    @BeforeSuite
    public void beforeSuite() throws Exception {
//        properties = new Properties();
//        String location = System.getProperty("user.dir") + "/config.properties";
//        FileInputStream fi = new FileInputStream(location);
//        properties.load(fi);
    }
}
