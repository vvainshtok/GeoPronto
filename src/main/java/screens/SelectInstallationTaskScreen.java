package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class SelectInstallationTaskScreen extends BaseScreen{
    public SelectInstallationTaskScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@text='Confirmed']")
    AndroidElement textConfirmed;

    public boolean isConfirmedTaskPresent() {
        return isTextInElementPresent(textConfirmed, "Confirmed", 3);

    }

    //TouchAction action = new TouchAction(driver);
    //    action.longPress(bottomElement).moveTo(topElement).release().perform();
}
