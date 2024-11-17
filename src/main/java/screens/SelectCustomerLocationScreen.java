package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class SelectCustomerLocationScreen extends BaseScreen {
    public SelectCustomerLocationScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.geopronto.app.test.debug:id/button_approve")
    AndroidElement btnSkip;

    public StepsListScreen clickBtnSkip() {
        btnSkip.click();
        return new StepsListScreen(driver);
    }
}
