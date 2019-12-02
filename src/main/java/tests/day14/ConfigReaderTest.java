package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationReader;

public class ConfigReaderTest {


    @Test
    public void test1() {
        String expectedBrowser = "firefox";
        //we write keys in "key" as a string
        //as return, you will get value
        //key=value
        //property name = value
        //we don't change property names, we change values
        //the idea is change in the one place, and affect entire framework
        //lets say every class will read browser type from properties file
        //and to perform cross-browsing testing, we can easily change value of browser property
        String actualBrowser = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actualBrowser, expectedBrowser);
       //read value of ulr property
        System.out.println("URL: "+ConfigurationReader.getProperty("url"));
        //read value of username
        System.out.println("Username: "+ConfigurationReader.getProperty("user_name"));
        //read value of password
        System.out.println("Password: "+ConfigurationReader.getProperty("password"));


    }
}