package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class MaterialsScreen extends BaseScreen {
    public MaterialsScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.geopronto.app.test.debug:id/edit_icon']")
    AndroidElement picEditFirstMaterial;

    @FindBy(xpath = "//*[@text='2']")
    AndroidElement element2;

    @FindBy(id = "com.geopronto.app.test.debug:id/button_approve")
    AndroidElement btnEnter;

    @FindBy(id = "android:id/text1")
    AndroidElement btnSelectMaterial;

    @FindBy(id = "com.geopronto.app.test.debug:id/button_next")
    AndroidElement btnNext;

    public StepsListScreen selectMaterialsForSmokeTest() {
        picEditFirstMaterial.click();
        btnSelectMaterial.click();
        element2.click();
        btnNext.click();
        btnEnter.click();
        return new StepsListScreen(driver);
    }
}
