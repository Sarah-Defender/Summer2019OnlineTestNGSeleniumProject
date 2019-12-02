package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitsPractice {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }
    @Test
    public void test1(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Dynamic Loading")).click();
       //partiallinktext contains text
        driver.findElement(By.partialLinkText("Example 2")).click();

        driver.findElement(By.tagName("button")).click();

        WebElement finishElement = driver.findElement(By.id("finish"));
    }

    @Test
    public void test2(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        //select Example #1
        driver.findElement(By.partialLinkText("Example 1")).click();
        //click on start button
        driver.findElement(By.tagName("button")).click();
      //enter username and set explicit wait
        //we find element first but the problem is element can be present but not visible
        WebElement userNameInputBox = driver.findElement(By.id("username"));
        WebDriverWait wait = new WebDriverWait(driver,10);
        //how to apply condition
        wait.until(ExpectedConditions.visibilityOf(userNameInputBox));
        userNameInputBox.sendKeys("tomsmith");

        WebElement passwordInputBox = driver.findElement(By.id("pwd"));
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");

        //for submitting username and password
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();

        WebElement message = driver.findElement(By.tagName("h4"));
        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = message.getText();
        BrowserUtils.wait(5);
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void test3() {
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 5")).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);

        WebElement overlayScreen = driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']"));
        //wait until overlay screen disapear, or we'll have issue to click or enter the text
        wait.until(ExpectedConditions.invisibilityOf(overlayScreen));
        WebElement userNameInputBox = driver.findElement(By.id("username"));

        wait.until(ExpectedConditions.visibilityOf(userNameInputBox));
        userNameInputBox.sendKeys("tomsmith");
        WebElement passwordInputBox = driver.findElement(By.id("pwd"));

        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();

        WebElement message = driver.findElement(By.tagName("h4"));
        wait.until(ExpectedConditions.visibilityOf(message));

        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = message.getText();

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test(description = "Fluent wait example")
    public void test4(){
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 2")).click();
        driver.findElement(By.tagName("button")).click();

        Wait wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class).ignoring(ElementNotVisibleException.class);

        WebElement message = (WebElement) wait.until(new Function<WebDriver, WebElement>(){

            public WebElement apply(WebDriver driver){
                return driver.findElement(By.id("finish"));
            }
        });
    }



    @AfterMethod
    public void teardown() {
        driver.quit();

    }




}
