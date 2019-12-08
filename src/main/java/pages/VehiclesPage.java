package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class VehiclesPage extends BasePage {

    @FindBy(css="[title='Create Car']")
    public WebElement CreateACarElement;

    public void clickToCreateACar(){
        BrowserUtils.waitForClickablility(CreateACarElement,10);
        BrowserUtils.waitForClickablility(CreateACarElement,10);

        CreateACarElement.click();
    }


}
