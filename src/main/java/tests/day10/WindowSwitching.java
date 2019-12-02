package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Set;

public class WindowSwitching {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @Test
      public void test1(){
        driver.findElement(By.linkText("New tab")).click();
        BrowserUtils.wait(5);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Practice", "Title is wrong!");
      }

      public void test2(){
        driver.findElement(By.linkText("New tab")).click();
      //record id of original window
          String oldWindow = driver.getWindowHandle();
          //after 5 seconds, another website will be opened, in the second window
          //selenium doesn't switch automatically to new window
        BrowserUtils.wait(5);
        //in the selenium every window has an id, that id calls window handle
        //to read window handle we use a method getWindowHandle()
         //after new window was opened, we can get list of all window id's/ window handles
         //list -- it's a data structure      set--is also a data structure, but it doesn't allow duplicates
         //also, you cannot easily access anything from there
         //there is no .get() method
         //that's why , we need to loop through the set, to read a data from there
         Set<String> windowHandles = driver.getWindowHandles();
         for(String windowHandle: windowHandles ) {
             //if it's not an old window
             if(! windowHandle.equals(oldWindow)){
                 //switch to that window
                 driver.switchTo().window(windowHandle);
             }
         }
    //let's verify the title of new window is a fresh tab
          System.out.println(driver.getTitle());
         Assert.assertEquals(driver.getTitle(), "Fresh tab", "Title is wrong!");
      }

//how to upload file in the selenium:  .send()

  @AfterMethod
    public void teardown(){
        driver.quit();
  }


}
