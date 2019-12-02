package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class WebTablePractice {

    private WebDriver driver;
    private  WebDriverWait wait;

   //table
    //thread---table header
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));

    }

    @Test(description = "Print table 1 data")
    public void test1(){
        WebElement table = driver.findElement(By.id("table1"));
        System.out.println(table.getText());
    }

    @Test(description = "Verify that number of column equal to 6")
    public void test2(){
        int actualColumnNumber = driver.findElements(By.xpath("//table[@id='table1']//th")).size();
        int expectedColumnNumber = 6;
        Assert.assertEquals(actualColumnNumber,expectedColumnNumber);
    }

    @Test(description = "Verify that number of rows is equals to 5")
    public void tet3(){
        int expectedRowCount = 5;
        int actualRowCount = driver.findElements(By.xpath("//table[@id='table1']//tr")).size();
        Assert.assertEquals(actualRowCount,expectedRowCount);
    }

     @Test(description = "Print all values from the 2nd row(excluding table header)")
     public void test4(){
         List<WebElement> row = driver.findElements(By.xpath("//table[@id='table']//tbody//tr[2]//td"));
         for(WebElement cell : row){
             System.out.println(cell.getText());
         }
     }

     @Test(description = "")
     public void test5(){

        int index =1;
        List<WebElement> row= driver.findElements(By.xpath("//table[@id='table']//tbody//tr[" + index + "]//td"));
        for(WebElement cell : row){
            System.out.println(cell.getText());
        }
     }

      @Test(description = "Verify that every email contain '@' ")
     public void test7(){
    //get all emails, td[3] means 3rd column, we are skipping tr, becoz we need data from all rows
     List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']//tbody//td[3]"));
     for(WebElement email:emails){
         System.out.println(email.getText());
         Assert.assertTrue(email.getText().contains("@"));
     }
    }

    /*
    Step 1. Click on last name
    Step 2. Get all vlues from " last name" column
    Step 3. Verify that column is sorted in alphabetic order
     */
    @Test(description = "Verify that after click on the last name, value will be sorted in alphabetic order")
    public void test8(){
       //if result is less than 0, sequence of words is correct
       //if result is 0, words are equal
       //if result is positive, sequence of words is opposte to alphabetic
       WebElement lastNameElement = driver.findElement(By.xpath("//table[@id='table1']//*[text()='Last Name']"));
       lastNameElement.click();
       List<WebElement> lastNames = driver.findElements(By.xpath("//table[@id='table1']//tbody//td[1]"));
       for(int index = 0; index < lastNames.size()-1;index++){
           String lastName = lastNames.get(index).getText();
           String followingLastName = lastNames.get(index+1).getText();
           System.out.println("#### Iteration: "+index);
           Assert.assertTrue(lastName.compareTo(followingLastName)<0);
       }
    }



     public void teardown(){
        driver.close();
    }


}
