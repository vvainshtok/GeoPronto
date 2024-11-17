package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class SelectInstallationTaskStartScreen extends BaseScreen {
    public SelectInstallationTaskStartScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.geopronto.app.test.debug:id/button_approve")
    AndroidElement btnStart;

    public SelectCustomerLocationScreen clickBtnStart() {
        btnStart.click();
        return new SelectCustomerLocationScreen(driver);
    }
}
