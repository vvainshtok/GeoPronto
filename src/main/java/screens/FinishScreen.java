package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class FinishScreen extends BaseScreen {
    public FinishScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.geopronto.app.test.debug:id/button_approve")
    AndroidElement btnConfirm;

    @FindBy(id = "com.geopronto.app.test.debug:id/radio_yes")
    AndroidElement radioBtnYes;

    @FindBy(id = "com.geopronto.app.test.debug:id/button_next")
    AndroidElement btnNext;

    public void finishTask() {
        clickWait(btnConfirm, 30);
        radioBtnYes.click();
        btnNext.click();
        btnConfirm.click();
    }
}
