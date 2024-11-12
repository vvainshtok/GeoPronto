package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class MainScreen extends BaseScreen {
    public MainScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.android.packageinstaller:id/permission_message")
    AndroidElement permissionMessage;

    @FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    AndroidElement allowButton;





    public MainScreen allowAccessLocation() {
      pause(5);
        if(textInElementPresent(permissionMessage,
                "Allow Pronto App Android to access this device's location?", 3)) {
             allowButton.click();
          }
        return this;
    }

    public MainScreen allowPictures() {
        pause(5);
        if(textInElementPresent(permissionMessage,
                "Allow Pronto App Android to take pictures and record video?", 3)) {
            allowButton.click();
        }
        return this;
    }
}
