package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
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
        stepContract.click();
        return new ContractScreen(driver);
    }
    public NetworkScreen selectStepNetwork() {
        stepNetwork.click();
        return new NetworkScreen(driver);
    }
    public MACScreen selectStepMAC() {
        stepMAC.click();
        return new MACScreen(driver);
    }
    public TestScreen selectStepTest() {
        stepTest.click();
        return new TestScreen(driver);
    }
    public WiFiPropertiesScreen selectStepWiFiProperties() {
        stepWiFiProperties.click();
        return new WiFiPropertiesScreen(driver);
    }
    public MaterialsScreen selectStepMaterials() {
        stepMaterials.click();
        return new MaterialsScreen(driver);
    }
    public PhotosScreen selectStepPhotos() {
        stepPhotos.click();
        return new PhotosScreen(driver);
    }
    public FinishScreen selectStepFinish() {
        stepFinish.click();
        return new FinishScreen(driver);
    }
}


