package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FindElementsTest {
//WebElement represents any kind of element on the page
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        String expectedTitle = driver.getTitle();
        // Step 1. Open inspector in chrome and find locator for the element
        // Step 2. Create object of WebElement
        // Step 3. Use webelement
        WebElement button = driver.findElement(By.id("form_submit"));
        //to click on the element
        button.click();
       String actualTitle = driver.getTitle();
       if(actualTitle.equals(expectedTitle)){
           System.out.println("test passed");
       }else{
           System.out.println("tets failed");
           System.out.println("Expected title: " + expectedTitle);
           System.out.println("Actual title: "+ actualTitle);
       }
        BrowserUtils.wait(2);
        driver.close();

    }
/*  For automation: First you need to find elemnents. For this, we have 8 locators.
                  id / name / tagname / class / xpath / cssSelector / linkText / partialLinkText
    as of today we are using id.

    ID it's the best way to find element. ID must be unique. Also, in terms of performance,
    it's the fastest way to find element.

 */
}
