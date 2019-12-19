package tests.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeworkForSynchronization_Checkbox_Locators {
    /* Testcase#1
    1.Go to “https://qa1.vytrack.com/"
    2.Login as a store manager
    3.Navigate to “Activities -> Calendar Events”
    4.Verify that page subtitle "Options" is displayed
     */
   private WebDriver driver;
   private WebDriverWait wait;

    @BeforeMethod
    public void setup() throws InterruptedException{
           driver= BrowserFactory.getDriver("chrome");
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          wait= new WebDriverWait(driver,10);
           driver.get("https://qa1.vytrack.com/user/login");

           driver.findElement(By.cssSelector("[id='prependedInput']")).sendKeys("storemanager85");
           Thread.sleep(1000);
           driver.findElement(By.cssSelector("[id='prependedInput2']")).sendKeys("UserUser123", Keys.ENTER);


        WebElement activities = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activities));
        wait.until(ExpectedConditions.elementToBeClickable(activities));
        Thread.sleep(3000);
        activities.click();

        WebElement calendarEvent = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEvent));
        calendarEvent.click();

        WebElement loadMask = driver.findElement(By.cssSelector("div[class='loader-mask']"));
        wait.until(ExpectedConditions.invisibilityOf(loadMask));
    }

    @Test(description = "verify that page subtitle 'Option' is displayed")
     public void test1(){
        WebElement option = driver.findElement(By.cssSelector("div[class='btn btn-link dropdown-toggle']"));
        Assert.assertTrue(option.isDisplayed(),"Option button is not displayed");
     }

    /*test#2
   1.Go to “https://qa1.vytrack.com/"
   2.Login as a store manager
   3.Navigate to “Activities -> Calendar Events”
   4.Verify that page number is equals to "1"
     */
    @Test(description = "Verify that page number is equals to '1'")
    public void test2(){
        String actual = driver.findElement(By.cssSelector("[type='number']")).getAttribute("value");
        Assert.assertEquals(actual,"1", "page number is not equal to 1");
    }

    /*Test#3
    1.Go to “https://qa1.vytrack.com/"
    2.Login as a store manager3.Navigate to “Activities -> Calendar Events”
    4.Verify that view per page number is equals to "25"
     */
   @Test(description = "Verify that view per page number is equals to '25' ")
    public void test3(){
          String actualNum= driver.findElement(By.className("btn dropdown-toggle ")).getText();
          Assert.assertEquals(actualNum,"25","view per page number is not equal to 25");
    }

    /*Test#4
    1.Go to “https://qa1.vytrack.com/"2.Login as a store manager3.Navigate to “Activities -> Calendar Events”
    4.Verify that number of calendar events (rows in the table) is equals to number of records
    Hint: In HTML, <table> tag represents table, <thread> - table header, <tr> tag represents table row element,
     <th> table header cell and <td> table data.
     */
  @Test(description = "Verify that number of calendar events (rows in the table) is equals to number of records")
    public void test4(){
      List<WebElement> list = driver.findElements(By.xpath("//*[@class= 'grid-row row-click-action']"));
      System.out.println("Size: "+list.size());
      int actual = list.size();
      Assert.assertEquals(actual,9, "Number of the calendar event is NOT equal to the number of records!");
  }

   /*
   1.Go to “https://qa1.vytrack.com/" 2.Login as a store manager 3.Navigate to “Activities -> Calendar Events”
   4.Click on the top checkbox to select all5.Verify that all calendar events were selected
    */
  @Test(description = "Verify that all calendar events were selected when clicking the 'select all' checkbox")
   public void test5() throws Exception{
       driver.findElement(By.xpath("//button[@class='btn btn-default btn-small dropdown-toggle']/child::input")).click();
       List<WebElement> list=driver.findElements(By.xpath("//input[@tabindex='-1']"));
       Thread.sleep(1000);
       for(WebElement each:list){
           Assert.assertTrue(each.isSelected(),"Element "+each+" is not selected");
       }
  }
/*
1.Go to “https://qa1.vytrack.com/"2.Login as a store manager3.Navigate to “Activities -> Calendar Events”
4.Select “Testers meeting”5.Verify that following data is displayed:
 */
  @Test(description = "")
   public void test6(){
      driver.findElement(By.xpath("//*[.='Testers meeting']")).click();

      WebElement mask=driver.findElement(By.cssSelector("[class = 'loader-mask']"));
      wait.until(ExpectedConditions.invisibilityOf(mask));

      List<WebElement> controlLabl=driver.findElements(By.cssSelector("[class = 'control-label']"));
      for(WebElement each:controlLabl){
          Assert.assertTrue(each.isDisplayed(),"Element "+each.getText()+" is not displayed");
      }
   }

public void teardown(){
      driver.quit();
}


}
