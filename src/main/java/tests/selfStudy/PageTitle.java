package tests.selfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTitle {
    public static void main(String[] args) {
        //to set up chromedriver
        WebDriverManager.chromedriver().setup();
        //to create an object of chromedriver class
        ChromeDriver driver = new ChromeDriver();
       driver.manage().window().fullscreen();
        driver.get("http://google.com");
        String title = driver.getTitle();
        System.out.println(title);
    }
}
