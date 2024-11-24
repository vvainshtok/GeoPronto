package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public void pause(int time) {
        try {
            Thread.sleep(1000L * time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setArequipaLocation() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-geolocation");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "navigator.geolocation.getCurrentPosition = function(success, error, options) {" +
                        "    success({" +
                        "        coords: {" +
                        "            latitude: -16.422649, longitude: -71.487012, accuracy: 100" + // New York City coordinates
                        "        }" +
                        "    });" +
                        "};");

    }

}
