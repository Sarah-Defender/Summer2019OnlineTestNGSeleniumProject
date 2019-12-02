package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class WarmUp {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://cybertekschool.com");
        //how to find all links?
        //every link as a tag name <a>
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        //size of the list = number of links
        //findElement vs findElements
        //findElement = only 1 element
        //findElements = 0 0r more than 1 elements
        System.out.println("Number of links: "+links.size());
        //what if i want to print text of all links, one by one
        for(WebElement WebElement: links){
            //print text of every link
            System.out.println(WebElement.getText());
        }
    }
}
