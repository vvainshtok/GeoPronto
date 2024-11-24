package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class MACScreen extends BaseScreen {
    public MACScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.widget.LinearLayout" +
            "/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup" +
            "/android.widget.FrameLayout/android.view.ViewGroup" +
            "/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]" +
            "/android.view.ViewGroup/android.widget.ImageView[2]")
    AndroidElement picEditMAC;

    @FindBy(xpath = "//*[@class = 'android.widget.RadioButton']")
    AndroidElement firstRadioBtn;

    @FindBy(id = "com.geopronto.app.test.debug:id/button_next")
    AndroidElement btnNext;

    @FindBy(id = "com.geopronto.app.test.debug:id/button_approve")
    AndroidElement btnConfirm;

    public StepsListScreen selectMAC() {
        picEditMAC.click();
        firstRadioBtn.click();
        btnNext.click();
        btnConfirm.click();
        return new StepsListScreen(driver);
    }
}
