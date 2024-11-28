package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static utils.PropertiesReader.getProperty;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        setDriver(driver);
        driver.get(getProperty("data.properties","urlInstPage"));
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//*[@id = 'login']")
    WebElement inputLogin;
    @FindBy(xpath = "//*[@id = 'input-27']")
    WebElement inputPassword;
    @FindBy(xpath = "//button[@class='v-btn v-btn--is-elevated v-btn--has-bg theme--light v-size--default primary']")
    WebElement btnLogin;

    public InstallationPage typeLoginForm() {
        if(inputLogin.isDisplayed()) {
            inputLogin.sendKeys(getProperty("data.properties", "login"));
            inputPassword.sendKeys(getProperty("data.properties", "password"));
            btnLogin.click();
        }
        return new InstallationPage(driver);
    }
}
