package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class LocatorsPracticeXpath2 {
    public static void main(String[] args) throws Exception {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        WebElement headerText = driver.findElement(By.xpath("//span[@class='h1y']"));
        WebElement contextMenuLink = driver.findElement(By.xpath("//a[.='Context Menu']"));
        System.out.println("h1 text: "+headerText.getText());
        contextMenuLink.click();
        Thread.sleep(3000);
        driver.close();



    }
}
