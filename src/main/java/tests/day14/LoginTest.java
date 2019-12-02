package tests.day14;

import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

public class LoginTest {

    public static void main(String[] args) {
       //read url from property file
        String url = ConfigurationReader.getProperty("url");

        Driver.get().get(url);

        BrowserUtils.wait(2);
        Driver.close();

    }

}
