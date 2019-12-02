package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class ReadAttributesTest {

    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement input = driver. findElement(By.name("name"));
        System.out.println(input.getAttribute("pattern"));
        input.sendKeys("random_email@email.com");
        //how to read entered text, it's gonna be inside value attribute



        driver.close();
    }
}
