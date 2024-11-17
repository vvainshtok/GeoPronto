package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class ContractScreen extends BaseScreen {
    public ContractScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.geopronto.app.test.debug:id/notification_icon")
    AndroidElement picCamera;

    //public
}
