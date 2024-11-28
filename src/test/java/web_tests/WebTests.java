package web_tests;

import api.ApiController;
import manager.ApplicationManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ConfirmPage;
import pages.InstallationPage;
import pages.LoginPage;

import java.util.Random;


public class WebTests extends ApplicationManager {

    InstallationPage installationPage;
    int taskNum;

    @BeforeMethod
    public void sendRequest() {
        taskNum= new Random().nextInt(1000) + 1000;
        ApiController.sendRequest(taskNum);
    }

    @Test
    public void nothing() {
        String urlConfirm = new LoginPage(getDriver())
                .typeLoginForm()
                .getUrlTask(taskNum);
        System.out.println("Url --> " + urlConfirm);
    }


    @Test
    public void webTest() {
        String urlConfirm = new LoginPage(getDriver())
                .typeLoginForm()
                .getUrlTask(taskNum);
        System.out.println("Url --> " + urlConfirm);
        getDriver().get(urlConfirm);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript(
                "navigator.geolocation.getCurrentPosition = function(success, error, options) {" +
                        "    success({" +
                        "        coords: {" +
                        "            latitude: -16.422649, longitude: -71.487012, accuracy: 100" +
                        "        }" +
                        "    });" +
                        "};");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new ConfirmPage(getDriver()).confirmTask();
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
