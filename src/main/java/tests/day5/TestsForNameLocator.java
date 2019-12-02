package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class TestsForNameLocator {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        //enter fullname:
        driver.findElement(By.name("full_name")).sendKeys("Test User");
        //enter email:
        driver.findElement(By.name("email")).sendKeys("test_email@email.com");
        //click sign up:
        driver.findElement(By.name("wooden_spoon")).click();

        driver.quit();
    }








}
