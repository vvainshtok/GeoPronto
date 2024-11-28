package experiment;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class GeolocationOverride {
    public static void main(String[] args) {
        // Set up ChromeDriver path
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeOptions options = new ChromeOptions();

        //options.addArguments("--disable-blink-features=AutomationControlled");
        //options.addArguments("--disable-geolocation");
        //options.addArguments("--disable-notifications"); //?
        //options.addArguments("--timezone=America/Lima"); //?


        //Map<String, Object> prefs = new HashMap<>();
        //prefs.put("profile.default_content_setting_values.geolocation", 1); // 1 = Allow
        //options.setExperimentalOption("prefs", prefs);


        // Start WebDriver
        WebDriver driver = new ChromeDriver(options);

        // Open target website
        //
        //driver.manage().window().maximize();
        driver.get("http://www.google.com");
        //driver.get("https://test.geopronto.com/iw/app/v1/1755772624354995269_1474");


        // Inject JavaScript to mock geolocation
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Object location = js.executeScript(
                "return new Promise((resolve, reject) => {" +
                        "    navigator.geolocation.getCurrentPosition(position => {" +
                        "        resolve({" +
                        "            latitude: position.coords.latitude," +
                        "            longitude: position.coords.longitude," +
                        "            accuracy: position.coords.accuracy" +
                        "        });" +
                        "    }, reject);" +
                        "});"
        );

        System.out.println("Current Location: " + location);

//driver.get("https://test.geopronto.com/iw/app/v1/1755772624354995269_1474");

        //driver.manage().deleteAllCookies();
        //js.executeScript("localStorage.clear(); sessionStorage.clear();");
        driver.get("https://test.geopronto.com/iw/app/v1/1755772624354995269_1474");
        js.executeScript("navigator.geolocation.getCurrentPosition = function(success) {" +
                "    success({" +
                "        coords: {" +
                "            latitude: -16.422649, " +
                "            longitude: -71.487012, " +
                "            accuracy: 1 " +
                "        }" +
                "    });" +
                "};");

        // Wait to observe changes
        //driver.navigate().refresh();;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.get("https://test.geopronto.com/iw/app/v1/1755772624354995269_1474");
        //driver.navigate().refresh();;
        location = js.executeScript(
                "return new Promise((resolve, reject) => {" +
                        "    navigator.geolocation.getCurrentPosition(position => {" +
                        "        resolve({" +
                        "            latitude: position.coords.latitude," +
                        "            longitude: position.coords.longitude," +
                        "            accuracy: position.coords.accuracy" +
                        "        });" +
                        "    }, reject);" +
                        "});"
        );

        System.out.println("New Location: " + location);

        //driver.get("https://test.geopronto.com/iw/app/v1/10058296718345841158_1255");
        // Close browser
        //driver.quit();
    }
}