package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class AcceptInstallationTaskScreen extends BaseScreen {
    public AcceptInstallationTaskScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.geopronto.app.test.debug:id/chip_slot_1")
    AndroidElement btnTimeSlot1;
    @FindBy(id = "com.geopronto.app.test.debug:id/chip_slot_2")
    AndroidElement btnTimeSlot2;
    @FindBy(id = "com.geopronto.app.test.debug:id/chip_slot_3")
    AndroidElement btnTimeSlot3;

    @FindBy(id = "com.geopronto.app.test.debug:id/button_approve")
    AndroidElement btnAccept;
    @FindBy(id = "com.geopronto.app.test.debug:id/button_reject")
    AndroidElement btnReject;

    public MainScreen acceptFirstTimeSlot() {
       if(btnTimeSlot1.isDisplayed())
           btnTimeSlot1.click();
       btnAccept.click();
       return new MainScreen(driver);

    }


}
