package tests.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class BasicNavigation {
    private WebDriver driver;
/*Test case #1
Step 1. Go to https://practicecybertekschool.herokuapp.com
Step 2. Click on “Sign Up For Mailing List”
Step 3. Enter any valid name
Step 4. Enter any valid email
Step 5. Click on “Sign Up” button
Expected result: Following message should be
displayed: “Thank you for signing up. Click the
button below to return to the home page.” Home
button should be displayed.
 */
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
    }

    @Test(description = "Verify the message and home button")
    public void testcase1() throws InterruptedException{

        driver.findElement(By.xpath("//a[text()='Sign Up For Mailing List']")).click();

        WebElement name = driver.findElement(By.cssSelector("[type='text']"));
                name.sendKeys("Sayyare");
        WebElement email = driver.findElement(By.name("email"));
              email.sendKeys("sarah422.sa@gmail.com");

        Thread.sleep(1000);
        driver.findElement(By.cssSelector("[class='radius']")).click();

        String expected ="Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(By.xpath("//h3[@class ='subheader']")).getText();
        Assert.assertEquals(expected,actual,"Test Fail");

        //verify that home button is displayed
        WebElement homeButton = driver.findElement(By.id("wooden_spoon"));
        Assert.assertTrue(homeButton.isDisplayed(),"Home Button is not displayed, run the test again sarah!");
    }
       /*Test case #2 Step 1. Go to https://practice-cybertekschool.herokuapp.comStep
        2. Verify that number of listed examples is equals to 48.Hint: use findElemnts() and size() methods.
         */
       @Test(description = "Verify that numbers of lists are equal to 48")
       public void testcase2(){
           List<WebElement> list= driver.findElements(By.xpath("//*[@class='list-group-item']"));
           int expectedList = 48;
           System.out.println("Total number of list is: "+list.size());
           Assert.assertEquals(list.size(),expectedList,"Number of expected listed example is not equal to 48");
       }

       /*Test case #3
        Step 1. Go to https://practicecybertekschool.herokuapp.com
        Step 2. Click on “Multiple Buttons”
        Step 3. Click on “Button 1”
        Verify that result message is displayed: “Clicked on button one!” */

       @Test(description = "Verify that result message is displayed: 'Click on button one!' ")
        public void testcase3 (){
            driver.findElement(By.linkText("Multiple Buttons")).click();
            driver.findElement(By.cssSelector("[onclick='button1()']")).click();
            String expectedResult = "Clicked on button one!";
            String actualResult = driver.findElement(By.id("result")).getText();
            Assert.assertEquals(actualResult,expectedResult,"Message is wrong");
       }

       /* Test case #4
        Step 1. Go to https://practicecybertekschool.herokuapp.com
        Step 2. Click on “Registration Form”
        Step 3. Enter “123” into first name input box.
        Step 4. Verify that warning message is displayed: “first name can only consist of alphabetical letters”*/
      @Test(description = "Verify that warning message is displayed: First Name Box")
        public void testcase4(){
            driver.findElement(By.linkText("Registration Form")).click();
            driver.findElement(By.xpath("//*[@class='form-control'][1]")).sendKeys("123");
            WebElement result = driver.findElement(By.xpath("//*[@class='help-block'][3]"));
            Assert.assertTrue(result.isDisplayed());
        }

        @Test(description = "Verify that warning message is displayed: LAST NAME box")
      public void testCase5(){
          driver.findElement(By.linkText("Registration Form")).click();
          driver.findElement(By.name("username")).sendKeys("123");
          WebElement result = driver.findElement(By.cssSelector("[data-bv-for='username'][data-bv-validator='stringLength']"));
          Assert.assertTrue(result.isDisplayed(),"The last name can only consist of alphabetical letters and dash");

      }

    @Test (description = "Verify that warning message is displayed: USERNAME box")
    public void testCase6() {
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.name("username")).sendKeys("user");
        WebElement result = driver.findElement(By.cssSelector("[data-bv-for='username'][data-bv-validator='stringLength']"));
        Assert.assertTrue(result.isDisplayed(),"Wrong message");
    }
    @Test (description = "Verify that warning message is displayed: EMAIL box")
    public void testCase7() {
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("[placeholder*='email']")).sendKeys("esters@email");
        WebElement message1 = driver.findElement(By.xpath("//small[@data-bv-validator='emailAddress']"));
        WebElement message2 = driver.findElement(By.cssSelector("[data-bv-validator='regexp'][data-bv-for='email']"));
        Assert.assertTrue(message1.isDisplayed(), "First message is NOT displayed");
        Assert.assertTrue(message2.isDisplayed(), "Second message is NOT displayed");
    }
    @Test (description = "Verify that warning message is displayed: PHONE box")
    public void testCase8() {
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector(".form-control[name='phone']")).sendKeys("5711234354");
        WebElement message = driver.findElement(By.xpath("//*[contains(text(),'Phone format is not correct')] [@class='help-block']"));
        Assert.assertTrue(message.isDisplayed(), "Message is NOT displayed");
    }

    @AfterMethod
    public void teardown(){
          driver.quit();
    }


}
