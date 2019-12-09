package tests.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestNG_testcase_6 {
    /*Test case #6
    Step 1. Go to "https://www.tempmailaddress.com/" Step 2. Copy and save email as a string.
    Step 3. Then go to “https://practice-cybertekschool.herokuapp.com” Step 4. And click on “Sign Up For Mailing List".
    Step 5. Enter any valid name.Step 6. Enter email from the Step 2.Step 7. Click Sign Up
    Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
    Step 9. Navigate back to the “https://www.tempmailaddress.com/”
    Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
    Step 11. Click on that email to open it.Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”
    Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
     */

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
    }

    @Test(description = "Verify few steps of sending email")
      public void test(){
        driver.get("https://www.tempmailaddress.com/");
        String email=driver.findElement(By.id("email")).getText();
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.cssSelector("[type='text']")).sendKeys("Sarah Akram");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtils.wait(3);
        WebElement message = driver.findElement(By.cssSelector("[name=signup_message]"));
        Assert.assertTrue(message.isDisplayed());
        String expectedMSG ="Thank you for signing up. Click the button below to return to the home page.";
        String actualMSG =message.getText();
        Assert.assertEquals(expectedMSG,actualMSG,"expected message does not match with actual message!");

        driver.navigate().to("https://www.tempmailaddress.com");
        BrowserUtils.wait(2);

        WebElement newMSG = driver.findElement(By.xpath("//tr[@class='hidden-xs hidden-sm klikaciRadek newMail'][1]"));
        Assert.assertTrue(newMSG.isDisplayed());
        newMSG.click();
        BrowserUtils.wait(2);
        String expectedADD="do-not-reply@practice.cybertekschool.com";
        String  emailAdd = driver.findElement(By.cssSelector("[id='odesilatel']")).getText();
        Assert.assertEquals(emailAdd,expectedADD, "message is not from "+emailAdd);

        String expectedSubjt ="Thanks for subscribing to practice.cybertekschool.com!";
        String actualSubjt=driver.findElement(By.cssSelector("[id='predmet']")).getText();
        Assert.assertEquals(actualSubjt,expectedSubjt,"Subject is not "+expectedSubjt);
    }

    @AfterMethod
    public void teardown(){
       driver.quit();
    }

}
