package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserFactory;

public class LocatorsPracticeCSS {
    public static void main(String[] args) throws Exception{
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/registration_form");
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("James");
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Bond");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("sayyare");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("akram624@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Sarah422");
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("571-341-0049");
        driver.findElement(By.cssSelector("input[name='gender'][value='female']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("04/22/1989");
        Select select = new Select(driver.findElement(By.cssSelector("select[name='job_title']")));
        select.selectByVisibleText("SDET");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button[id='wooden_spoon']")).click();

         Thread.sleep(3000);
         driver.close();

    }
}
