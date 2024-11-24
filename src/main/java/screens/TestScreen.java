package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class TestScreen extends BaseScreen {
    public TestScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.geopronto.app.test.debug:id/button_start")
    AndroidElement btnTest;

    @FindBy(id = "com.geopronto.app.test.debug:id/button_confirm")
    AndroidElement btnConfirm;

    public StepsListScreen runTest() {
        btnTest.click();
        pause(2);
        clickWait(btnTest, 20);
        clickWait(btnConfirm, 40);
        return new StepsListScreen(driver);
    }
}
