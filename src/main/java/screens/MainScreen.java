package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class MainScreen extends BaseScreen {
    public MainScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.android.packageinstaller:id/permission_message")
    AndroidElement msgPermission;

    @FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    AndroidElement btnAllow;

    @FindBy(id = "com.geopronto.app.test.debug:id/open_menu_fab")
    AndroidElement btnMenu;

    @FindBy(id = "com.geopronto.app.test.debug:id/ongoing_events_fab")
    AndroidElement btnOngoingEvents;

    @FindBy(id = "com.geopronto.app.test.debug:id/search_node_fab")
    AndroidElement btnInstallation;


    public MainScreen allowAccessLocation() {
      pause(3);
        if(isTextInElementPresent(msgPermission,
                "Allow Pronto App Android to access this device's location?", 1)) {
             clickWait(btnAllow, 1);
          }
        return this;
    }

    public MainScreen allowPictures() {
        pause(3);
        if(isTextInElementPresent(msgPermission,
                "Allow Pronto App Android to take pictures and record video?", 1)) {
            clickWait(btnAllow, 1);
        }
        return this;
    }

    public MenuScreen clickMenuButton() {
        clickWait(btnMenu, 2);
        return new MenuScreen(driver);
    }

    public OngoingEventsScreen clickOngoingEventsButton() {
        if(btnOngoingEvents.isDisplayed())
            clickWait(btnOngoingEvents, 2);
        return new OngoingEventsScreen(driver);
    }

    public SelectInstallationTaskScreen clickInstallationButton() {
        clickWait(btnInstallation, 3);
        return new SelectInstallationTaskScreen(driver);
    }


}
