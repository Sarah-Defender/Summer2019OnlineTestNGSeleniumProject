package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;
import utils.Driver;

public class CreateCarPage extends BasePage {
    @FindBy(css = "[id^='custom_entity_type_LicensePlate']")
    public WebElement licensePlateElement;
    @FindBy(name = "custom_entity_type[Driver]")
    public WebElement driverElement;
    @FindBy(name = "custom_entity_type[Location]")
    public WebElement locationElement;
    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement saveAndCloseButtonElement;
    @FindBy(css = "div[id*='FuelType']")
    public WebElement fuelTypeElement;

    @FindBy(name = "custom_entity_type[Logo][file]")
    public WebElement logoElement;


    /**
     * This method stands for selecting tags
     * Provide tag name to select
     * If checkbox already selected, it will not do anything
     *
     * @param tagName - represents name of tag that has to be selected, like Junior, Senior or Purchased
     * @return webelement of checkbox that was selected
     * <p>
     * CreateCarPage createCarPage = new CreateCarPage();
     * <p>
     * createCarPage.selectTags("Senior"); // Senior tag will be selected
     */
    public WebElement selectTags(String tagName) {
        //locator for checkbox is based on label name
        //label and checkbox are siblings
        String locator = "//label[text()='" + tagName + "']/preceding-sibling::input[@type='checkbox']";
        WebElement checkBox = Driver.get().findElement(By.xpath(locator));
        BrowserUtils.waitForVisibility(checkBox, 15);
        BrowserUtils.waitForClickablility(checkBox, 15);
        if (!checkBox.isSelected()) {
            checkBox.click();
        }
        return checkBox;
    }

    public void selectFuelType(String fuelType) {
        String locator = "//div[@class='select2-result-label' and text()='" + fuelType + "']";
        BrowserUtils.waitForClickablility(fuelTypeElement, 15);
        fuelTypeElement.click();
        WebElement fuelTypeSelectionElement = Driver.get().findElement(By.xpath(locator));
        BrowserUtils.waitForClickablility(fuelTypeSelectionElement, 15);
        fuelTypeSelectionElement.click();
    }

    public void uploadLogo(String pathToTheFile){
        locationElement.sendKeys(pathToTheFile);
    }


}
