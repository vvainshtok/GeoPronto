package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static utils.PropertiesReader.getProperty;

public class ConfirmPage extends BasePage {

    public ConfirmPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//*[text()='Confirm']")
    WebElement btnConfirm;
    @FindBy(id = "calendar_select_next_day")
    WebElement btnNextDay;

    public void confirmTask() {
        btnConfirm.click();
        btnNextDay.click();
        pause(2);
        btnNextDay.click();
        pause(2);
        btnConfirm.click();
    }



}
