package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class NetworkScreen extends BaseScreen {
    public NetworkScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout" +
            "/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView" +
            "/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.ImageView")
    AndroidElement picEditPort;

    @FindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
            "/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout" +
            "/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView" +
            "/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.ImageView")
    AndroidElement picEditCintillo;

    @FindBy(id = "android:id/text1")
    AndroidElement btnSelectEditPort;

    @FindBy(id = "com.geopronto.app.test.debug:id/button_next")
    AndroidElement btnNext;

    @FindBy(xpath = "//*[@text='01']")
    AndroidElement element01;

    @FindBy(id = "com.geopronto.app.test.debug:id/edit")
    AndroidElement inputCintillo;

    @FindBy(id = "com.geopronto.app.test.debug:id/button_approve")
    AndroidElement btnConfirm;

    public StepsListScreen selectPort01AndEnterCintillo(String cintillo) {
        clickWait(picEditPort, 20);
        // picEditPort.click();
        btnSelectEditPort.click();
        element01.click();
        btnNext.click();
        picEditCintillo.click();
        inputCintillo.sendKeys(cintillo);
        btnNext.click();
        btnConfirm.click();
        return new StepsListScreen(driver);
    }

}
