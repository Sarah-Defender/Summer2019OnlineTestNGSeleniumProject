package tests.selfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocatorsPractice {
    public static void main(String[] args) throws Exception {
        //to set up chromedriver
        WebDriverManager.chromedriver().setup();
        //to create object of chromeDriver class
        WebDriver driver = new ChromeDriver();
        //to maximize the window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://google.com");
        WebElement btn1 = driver.findElement(By.id("gbqfbb"));
        String actualText = btn1. getAttribute("value");
        String expectedText = "I'm Feeling Lucky";
        if(actualText.equals(expectedText)){
            System.out.println("test passed");
        }else{
            System.out.println("Failed");
            System.out.println("expected text:"+expectedText);
            System.out.println("Actual text: "+actualText);
        }
        Thread.sleep(5000);
        driver.close();
    }
}
