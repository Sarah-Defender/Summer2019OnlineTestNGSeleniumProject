package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class BitrixLogin {
    public static void main(String[] args) {
        //getDriver method returns object of webdriver, we need Webdriver object to send commands to the browser
        //left side is a reference variable to reuse this object
        WebDriver driver = BrowserFactory.getDriver("chrome");
        //go to bitrix
         driver.get("https://login1.nextbasecrm.com/?login=yes");
         //enter email
        //WebElement email = driver.findElement("");
        //email.sendKeys("email@email.com");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("helpdesk59@cybertekschool.com");

        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("UserUser");

        driver.close();





    }




}
