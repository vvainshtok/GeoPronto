package screens;

import config.AppiumConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class MenuScreen extends BaseScreen {
    public MenuScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.geopronto.app.test.debug:id/reload")
    AndroidElement reloadButton;

    @FindBy(id = "com.geopronto.app.test.debug:id/logout")
    AndroidElement logoutButton;

    public MainScreen clickReloadButton() {
        reloadButton.click();
        return new MainScreen(driver);
    }
}


