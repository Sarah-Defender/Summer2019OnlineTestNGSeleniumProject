package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class RadioButtons {
   //cammand + shift +L ---to organise code for Mac
   //control+ Alt + L====to organize code for Window
    private WebDriver driver;//it's private coz only will be use in this class

    @BeforeMethod
    public void  setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        //to go to Radio Buttons page
        // <a href ="/radio_buttons">Radio Button</a>
        //linkText only work with <a> elements
        //link test only in between >Text<
        //this step is commin for all test cases
        driver.findElement(By.linkText("Radio Buttons")).click();
    }

    @Test(description = "Verify that blue button is selected")
    public void test1(){
        //find blue radio button
        WebElement blueButton = driver.findElement(By.id("blue"));
        //let's verify that radio button is selected
        //assert true tat button is selected
        //if button is selected, it will return true, otherwise false
        boolean isSelected = blueButton.isSelected();
        Assert.assertTrue(isSelected);// will expect that isSelected is true
    }

    @Test(description = "Verify that red button is not selected")
    public void test2(){
        WebElement redButton = driver.findElement(By.id("red"));
        //isSelected will return true if button already clicked
        Assert.assertFalse(redButton.isSelected());//assertFalse will expect that condition is false
    }

    @Test(description = "Verify that green button is not clickable")
     public void test3(){
        WebElement greenButton = driver.findElement(By.id("green"));
        //isEnabled() will return true if button is available for interaction
        //that means you can click on it, in this case
        Assert.assertFalse(greenButton.isEnabled());
     }

     // find all radio buttons and click on them one by one
    @Test(description = "Click on all radio buttons")
    public void test4(){
        //how to find all radio buttons? find all radio button
        //any radio button will have type ='radio' and input as a element type
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
        //let's click only if button is not clicked and is available for clicking
        for(WebElement button: radioButtons){
      //      if button is available for clicking and not clicked yet
          if(button.isEnabled() && !button.isSelected()){
      //        then click on it
             button.click();
     // in this case, id attributes represent the name of the color, also there is no text in this element
     // that's why i print attribute value
              System.out.println("Button clicked: "+button.getAttribute("id"));
          }else{
              System.out.println("Button was not clicked: "+button.getAttribute("id"));
          }
            BrowserUtils.wait(1);//for demo
        }
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }



}
