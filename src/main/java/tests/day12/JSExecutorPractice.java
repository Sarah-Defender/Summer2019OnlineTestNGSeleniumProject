package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class JSExecutorPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
       driver = BrowserFactory.getDriver("chrome");

    }

    @Test(description = "")
    public void test1(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for(int i=0; i< 10; i++){
            //move 500px down
            js.executeScript("window.scrollBy(0, 500)");
            BrowserUtils.wait(1);
        }
        BrowserUtils.wait(3);
    }

    @Test(description = "scrolling with JSexecutor to specific element")
    public void test2(){
        driver.get("http://practice.cybertekschool.com/large");
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        BrowserUtils.wait(2);//for demo

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //this script must scroll, until link element is not visible
        //once link element will be visible , it will stop scrolling

        js.executeScript("arguments[0].scrollIntoView(true)",link);
        BrowserUtils.wait(2);
    }

    @Test(description = "Click with JS executor")
      public void test3(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement link1 = driver.findElement(By.partialLinkText("Example 1"));

        BrowserUtils.wait(2);//wait for demo

        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("argument[0].click()", link1);

        BrowserUtils.wait(2);

      }

   @Test(description = "Enter text with JS executor")
      public void test4(){
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement name = driver.findElement(By.name("full_name"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement submitButton = driver.findElement(By.name("wooden_spoon"));

        //to create java script object we need to cast webdriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].setAttribute('value', 'John Smith')", name);

        BrowserUtils.wait(2);
        js.executeScript("argument[0].setAttribute('value', 'someemail@email.com')", email);

        BrowserUtils.wait(2);
        js.executeScript("arguments[0].click()", submitButton);

        BrowserUtils.wait(2);

      }




    @AfterMethod
    public void after(){
     driver.quit();
    }

}
