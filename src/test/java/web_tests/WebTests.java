package web_tests;

import manager.ApplicationManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.InstallationPage;
import pages.LoginPage;



public class WebTests extends ApplicationManager {

    InstallationPage installationPage;
    @Test
    public void webTest() {
        new LoginPage(getDriver())
                .typeLoginForm()
                .getTasksList()
                .confirmTask();
       // installationPage.openNewTab(url);
        //new ConfirmPage(getDriver());

    }

    @Test
    public void changeGeoLocationTest() {
        ChromeDriver driver = new ChromeDriver();
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

        driver.get("https://www.google.com/maps");
        // new BasePage().setArequipaLocation();
        try {
            Thread.sleep(5000); // Wait 5 seconds to observe the behavior
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
