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

    @FindBy(xpath = "//*[@text='Gallery']")
    AndroidElement itemGallery;

    @FindBy(xpath = "//*[@resource-id='com.android.documentsui:id/icon_thumb']")
    AndroidElement firstPicture;

    @FindBy(id = "com.geopronto.app.test.debug:id/button_approve")
    AndroidElement btnUploadPhotos;

    public NetworkScreen uploadPhoto() {
        clickWait(picCamera, 2);
        itemGallery.click();
        clickWait(firstPicture, 2);
        clickWait(btnUploadPhotos, 2);
        pause(3);
        return new NetworkScreen(driver);
    }
}
