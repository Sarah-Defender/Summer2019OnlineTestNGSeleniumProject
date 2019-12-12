package tests.selfStudy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class CheckBoxesPractice {
    public static void main(String[] args) throws Exception {
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Checkboxes")).click();
        //Thread.sleep(2000);
        //driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(1)")).click();
        //Thread.sleep(2000);
        //driver.findElement(By.cssSelector("input[type='checkbox']:nth-of-type(2)")).click();
        //Thread.sleep(2000);
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        for(WebElement checkbox:checkboxes){
            Thread.sleep(2000);
            if(!checkbox.isSelected()){//if checkbox is not selected yet
                checkbox.click();//select it
            }
        }
//logic: find All element with tag name input, then loop through this list of element to find each element

        driver.quit();

    }

}
