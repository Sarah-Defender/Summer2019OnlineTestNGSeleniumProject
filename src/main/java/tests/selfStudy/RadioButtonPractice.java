package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class RadioButtonPractice {
    public static void main(String[] args) throws Exception {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.partialLinkText("Radio")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//label[.='Yellow']/preceding-sibling::input")).click();
        // Thread.sleep(2000);
        //System.out.println(driver.findElement(By.id("green")).isEnabled());
        // driver.findElement(By.id("green")).click();
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
       for(WebElement radio:radioButtons){
            System.out.println(radio.getText()+"-"+radio.isEnabled());
       }
        Thread.sleep(2000);
       driver.close();
    }
}
