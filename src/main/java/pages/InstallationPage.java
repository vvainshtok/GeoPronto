package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Optional;

public class InstallationPage extends BasePage {

    public InstallationPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//i[@class='v-icon notranslate mdi mdi-account-hard-hat theme--light']")
    WebElement btn2;

    @FindBy(xpath = "//i[@class='v-icon notranslate mdi mdi-account-group theme--light']")
    WebElement btn3;

    @FindBy(xpath = "//span[text()=' 20270681248 ']")
    WebElement generatedTask;

    @FindBy(xpath = "//button[@title = 'copy customer confirmation link']")
    WebElement btnWithUrl;

    String urlConfirm;

    public ConfirmPage getTasksList() {
        btn2.click();
        btn3.click();
        generatedTask.click();
        btnWithUrl.click();

        try {
            urlConfirm = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
                    .getData(DataFlavor.stringFlavor); // extracting the text that was copied to the clipboard
        } catch (UnsupportedFlavorException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.get(urlConfirm);



        return new ConfirmPage(driver);
    }



}
