package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.FindBy;

public class StepsListScreen extends BaseScreen {
    public StepsListScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath="//*[@text='Contract']")
    AndroidElement stepContract;

    @FindBy(xpath="//*[@text='Network']")
    AndroidElement stepNetwork;

    @FindBy(xpath="//*[@text='Repeaters']")
    AndroidElement stepRepeaters;

    @FindBy(xpath="//*[@text='MAC']")
    AndroidElement stepMAC;

    @FindBy(xpath="//*[@text='Test']")
    AndroidElement stepTest;

    @FindBy(xpath="//*[@text='WiFi properties']")
    AndroidElement stepWiFiProperties;

    @FindBy(xpath="//*[@text='Materials']")
    AndroidElement stepMaterials;

    @FindBy(xpath="//*[@text='Photos']")
    AndroidElement stepPhotos;

    @FindBy(xpath="//*[@text='Finish']")
    AndroidElement stepFinish;

    public ContractScreen selectStepContract() {
        clickWait(stepContract, 2);
        return new ContractScreen(driver);
    }
    public NetworkScreen selectStepNetwork() {
        clickWait(stepNetwork, 2);
        return new NetworkScreen(driver);
    }
    public MACScreen selectStepMAC() {
        clickWait(stepMAC, 2);
        return new MACScreen(driver);
    }
    public TestScreen selectStepTest() {
        TouchAction<?> action = new TouchAction<>(driver);
        action.longPress(PointOption.point(stepMAC.getCenter().x, stepMAC.getCenter().y))
                .moveTo(PointOption.point(stepContract.getCenter().x, stepContract.getCenter().y))
                .release()
                .perform();
        
        clickWait(stepTest, 2);
        return new TestScreen(driver);
    }
    public WiFiPropertiesScreen selectStepWiFiProperties() {
        clickWait(stepWiFiProperties, 2);
        return new WiFiPropertiesScreen(driver);
    }
    public MaterialsScreen selectStepMaterials() {
        clickWait(stepMaterials, 2);
        return new MaterialsScreen(driver);
    }
    public PhotosScreen selectStepPhotos() {
        clickWait(stepPhotos, 2);
        return new PhotosScreen(driver);
    }
    public FinishScreen selectStepFinish() {
        /* TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(PointOption.point(stepMaterials.getCenter()))
                .moveTo(PointOption.point(stepNetwork.getCenter()))
                .release()
                .perform();
         */
        clickWait(stepFinish, 20);
        return new FinishScreen(driver);
    }
}


