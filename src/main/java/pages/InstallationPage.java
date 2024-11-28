package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

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

    @FindBy(xpath = "//span[text()=' 20270681862 ']")
    WebElement generatedTask;

    @FindBy(xpath = "//button[@title = 'copy customer confirmation link']")
    WebElement btnWithUrl;

    String urlConfirm;

    public String getUrlTask(int taskNum) {
        pause(3);
        btn2.click();
        pause(3);
        btn3.click();
        pause(3);
        driver.findElement(By.xpath("//span[text()=' 2027068"
                + taskNum + " ']")).click();

        //generatedTask.click();
        btnWithUrl.click();
        pause(3);

        try {
            urlConfirm = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
                    .getData(DataFlavor.stringFlavor); // extracting the text that was copied to the clipboard
        } catch (UnsupportedFlavorException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //driver.get(urlConfirm);
        return urlConfirm;
        //return new ConfirmPage(driver);
    }



}
