package experiment;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetGeolocationWithoutDevTools {
    public static void main(String[] args) {
        // Configure ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-geolocation");

        // Create WebDriver instance
        WebDriver driver = new ChromeDriver(options);

        // Open a website that uses geolocation
        driver.get("https://www.google.com/maps");

        // Inject JavaScript to override geolocation
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "navigator.geolocation.getCurrentPosition = function(success, error, options) {" +
                        "    success({" +
                        "        coords: {" +
                        "            latitude: -16.422649, longitude: -71.487012, accuracy: 100" + // New York City coordinates
                        "        }" +
                        "    });" +
                        "};");

        // Wait to observe the change or interact with the page
        try {
            Thread.sleep(5000); // Wait 5 seconds to observe the behavior
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        //driver.quit();
    }
}
