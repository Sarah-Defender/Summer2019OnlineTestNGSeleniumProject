package tests.day3;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class NavigationPractice {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();//to maximize browser window
        driver.get("http://google.com");
        BrowserUtils.wait(3);//wait for 3 seconds this is out custom method since method is static,
                                    //we use class name to call the method, as a parameter, we provide number of seconds
        driver.navigate().to("http://amazon.com");
        //navigate back to google(previou)
        driver.navigate().back();
        //move forward to amazon again
        driver.navigate().forward();

        //to refresh a webpage/website
        driver.navigate().refresh();
        //shutdown browser
        driver.quit();//caution: you CANNOT call driver again after quit, otherwise you will get exception
                      // we have to recreate an objeect of WebDriver
    }
}
