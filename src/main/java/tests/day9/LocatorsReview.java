package tests.day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class LocatorsReview {
    private WebDriver driver;

   @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

   @Test(description = "Verify Checkboxes")
   public void test1(){
       driver.findElement(By.linkText("Checkboxes")).click();
       // [type='checkbox'] since there are 2 elements with a same locator
       //and I need only first one, i can use in css, :uth-of-type(index) 7th,8th etc...
       //it's very useful if you have more than one element under same css selector
       // any tag or tag+ attributes :nth-of-type(index)
       WebElement checkbox1 = driver.findElement(By.cssSelector("[type='checkbox']:nth-of-type(1)"));
       //how to verify if check box is not clicked?
       Assert.assertFalse(checkbox1.isSelected(),"Checkbox 1 was selected");//assert that checkbox was not selected
       WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
       Assert.assertTrue(checkbox2.isSelected(), "Checkbox 2 was not selected");
       //again, css selector is preferable, because of speed.
       // assertion is like if statement
//        if(true){
//            "test passed"
//        }else{
//            "test failed"
//                    throw new RuntimeException("Expected true but was false")
//        }

   }

   @Test(description = "Radio button test")
   public void test2(){
       driver.findElement(By.linkText("Radio Buttons")).click();
       WebElement blueButton = driver.findElement(By.xpath("//*[text()='Blue']/preceding-sibling::input[@type='radio']"));
     Assert.assertTrue(blueButton.isSelected(),"Blue button is not selected");
   }
    @AfterMethod
   public void teardown(){
       driver.quit();
   }







}
