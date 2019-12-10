package tests.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

/* Test case #7
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”  Step 2. And click on “File Upload".
Step 3. Upload any file with .txt extension from your computer. Step 4. Click “Upload” button.
Step 5. Verify that subject is: “File Uploaded!”  Step 6. Verify that uploaded file name is displayed.
 */
public class TestNG_testcase_7to12 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test(description = "Verify the subject is 'File upload'")
     public void test7() {
           driver.findElement(By.linkText("File Upload")).click();
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:/Users/akram/Desktop/sarah.txt");
        driver.findElement(By.id("file-submit")).click();
          WebElement subject = driver.findElement(By.xpath("//h3"));
          Assert.assertTrue(subject.isDisplayed());
          String expectedSub="File Uploaded!";
          String actualSub=subject.getText();
          Assert.assertEquals(expectedSub,actualSub,"expected subject does not match with actual subject!");
          WebElement UploadedFilename = driver.findElement(By.id("uploaded-files"));
         Assert.assertTrue(UploadedFilename.isDisplayed());
    }

      /*Test case #8
      Step 1. Go to “https://practice-cybertekschool.herokuapp.com” Step 2. And click on “Autocomplete”.
      Step 3. Enter “United States of America” into country input box.
      Step 4. Verify that following message is displayed: “You selected: United States of America”
      Optional: If you want to to be a real selenium hero, use @DataProvider for for tests cases from 9 through 12.
      Please use following documentation: https://testng.org/doc/documentation-main.html#parameters-dataproviders
       */
      @Test(description = "Verify the expected message is display after enter the country name")
      public void test8(){
          driver.findElement(By.linkText("Autocomplete")).click();
          driver.findElement(By.id("myCountry")).sendKeys("United States of America");
          driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();
          BrowserUtils.wait(2);
          WebElement result = driver.findElement(By.id("result"));
          String expectedrslt = "You selected: United States of America";
          String actualrslt = result.getText();
          Assert.assertTrue(result.isDisplayed());
          Assert.assertEquals(expectedrslt,actualrslt, "result is displayed but not match with expected result");
      }

      /* Test case #9
      Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
      Step 2. And click on “Status Codes”.
      Step 3. Then click on “200”.
      Step 4. Verify that following message is displayed: “This page returned a 200 status code”
       */
      @Test(description = "verify status code", dataProvider = "StatusCode")
      public void test9(String code){
          driver.findElement(By.linkText("Status Codes")).click();
          driver.findElement(By.xpath("//a[.="+code+"]")).click();
          WebElement message = driver.findElement(By.xpath("//p"));
          String expectedmsg = "This page returned a "+ code+" status code.\n" +
                  "\n" +
                  "For a definition and common list of HTTP status codes, go here";
          String actualmsg = message.getText();
          Assert.assertTrue(message.isDisplayed());
          Assert.assertEquals(expectedmsg,actualmsg,"expected message does not match with actual message");
      }

      @DataProvider(name="StatusCode")
      public Object[] statusCode(){
          return new Object[]{
                  "200", "301", "404", "500"
          };
      }


     public void teardown(){

          driver.quit();
     }




}
