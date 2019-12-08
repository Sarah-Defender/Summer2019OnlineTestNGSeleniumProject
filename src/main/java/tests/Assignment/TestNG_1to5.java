package tests.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class TestNG_1to5 {
    /* Testcase#1
       Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
       Step 2. Click on “Registration Form”
       Step 3. Enter “wrong_dob” into date of birth input box.
       Step 4. Verify that warning message is displayed: “The date of birth is not valid” */

      private WebDriver driver;

      @BeforeMethod
      public void setup(){
          driver= BrowserFactory.getDriver("chrome");
          driver.get("http://practice.cybertekschool.com/");
          driver.findElement(By.linkText("Registration Form")).click();
      }


      @Test(description = "Verify that warning message is displayed as expected")
     public void test1() throws Exception{
          driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("wrong_dob");
          WebElement message = driver.findElement(By.xpath("//form//div[8]//div//small[2]"));
          Assert.assertTrue(message.isDisplayed());
          String expectedMSG="The date of birth is not valid";
          String actualMSG= message.getText();
          Assert.assertEquals(expectedMSG,actualMSG,"Messages are not the same");
     }

     /* testcase#2
     Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     Step 2. Click on “Registration Form”
     Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
      */

     @Test(description = "Verify the options of 'c++, java, JavaScript' are displayed")
      public void test2(){
          List<WebElement> ProgLanguages = driver.findElements(By.cssSelector("[class='form-check form-check-inline']"));
          for(WebElement each:ProgLanguages){
              Assert.assertTrue(each.isDisplayed(), "Element "+each.getText()+" is not displayed");
          }
      }

     /* testcase#3
     Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     Step 2. Click on “Registration Form”
     Step 3. Enter only one alphabetic character into first name input box.
     Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
      */

     @Test(description = "Verify that first name box only accept 2-64 characters")
     public void test3(){
         driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("A");
         WebElement warningmsg = driver.findElement(By.xpath("//small[.='first name must be more than 2 and less than 64 characters long']"));
         Assert.assertTrue(warningmsg.isDisplayed());
         String expectedWarning = "first name must be more than 2 and less than 64 characters long";
         String actualWarning = warningmsg.getText();
         Assert.assertEquals(expectedWarning,actualWarning, "Warning message is not same as "+expectedWarning);
     }

     /* Testcase#4
       Step 1. Go to https://practice-cybertekschool.herokuapp.com
       Step 2. Click on “Registration Form”    Step 3. Enter only one alphabetic character into last name input box.
       Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
      */

     @Test(description = "Verify lastname must be between 2 to 64 charachters")
      public void test4(){
         driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("w");
         WebElement warningMSG=driver.findElement(By.xpath("//small[.='The last name must be more than 2 and less than 64 characters long']"));
         Assert.assertTrue(warningMSG.isDisplayed());
         String expectedMSG = "The last name must be more than 2 and less than 64 characters long";
         String actualMSG = warningMSG.getText();
         Assert.assertEquals(expectedMSG,actualMSG,"actual warning message does not match with expected warning message!");
      }

     /* Test case #5
     Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
     Step 2. Click on “Registration Form” Step 3. Enter any valid first name.
     Step 4. Enter any valid last name.Step 5. Enter any valid user name.
     Step 6. Enter any valid password.Step 7. Enter any valid phone number.
     Step 8. Select gender.Step 9. Enter any valid date of birth.Step 10. Select any department.
     Step 11. Enter any job title.Step 12. Select java as a programming language.
     Step 13. Click Sign up.Step 14. Verify that following success message is displayed:
     “You've successfully completed registration!”Note: for using dropdown,
      please refer to the documentation: https://selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/Select.html
      or, please watch short video about drop-downs that is posted on canvas. */

     @Test(description = "Verify that system message display 'You've successfully completed registration!' " +
             "when finished filling put the form")
     public void test5() throws Exception{
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
         WebElement  displayMSG =driver.findElement(By.xpath("//p"));
         Assert.assertTrue(displayMSG.isDisplayed());
         String expectedDisMsg="You've successfully completed registration!";
         String actualDisMsg = displayMSG.getText();
         Assert.assertEquals(expectedDisMsg,actualDisMsg, "confirm message is not same as expected message");
         Thread.sleep(3000);

     }


     public void teardown(){
          driver.quit();
     }


}


