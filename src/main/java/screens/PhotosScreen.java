package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.FindBy;

public class PhotosScreen extends BaseScreen {
    public PhotosScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@text='Dni']")
    AndroidElement textDni;

    @FindBy(xpath = "//*[@text='Recibo de Luz']")
    AndroidElement textReciboDeLuz;

    @FindBy(xpath = "//*[@text='Print de Speed test']")
    AndroidElement textPrintDeSpeedTest;

    @FindBy(xpath = "//*[@text='Conformidad de instalación']")
    AndroidElement textConformidadDeInstalacion;

    @FindBy(xpath = "//*[@text='Evidencia de Instalación']")
    AndroidElement textEvidenciaDeInstallacion;




    @FindBy(xpath = "//*[@resource-id='com.geopronto.app.test.debug:id/notification_icon']")
    AndroidElement firstPicCamera;

    @FindBy(xpath = "//*[@text='Gallery']")
    AndroidElement itemGallery;

    @FindBy(xpath = "//*[@resource-id='com.android.documentsui:id/icon_thumb']")
    AndroidElement firstPicture;

    @FindBy(id = "com.geopronto.app.test.debug:id/button_approve")
    AndroidElement btnUploadPhotos;


    int textWidth = textDni.getSize().width;
    int textHeight = textDni.getSize().height;
    int picWidth = firstPicCamera.getSize().width;
    int picHeight = firstPicCamera.getSize().height;

    public StepsListScreen uploadPhotos() {
        TouchAction<?> touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(textDni.getLocation().x + picWidth/2,
                        textDni.getLocation().y + textHeight + picHeight/2))
                .release()
                .perform();
        itemGallery.click();
        clickWait(firstPicture, 2);
        touchAction.press(PointOption.point(textReciboDeLuz.getLocation().x + picWidth/2,
                        textReciboDeLuz.getLocation().y + textHeight + picHeight/2))
                .release()
                .perform();
        itemGallery.click();
        clickWait(firstPicture, 2);
        touchAction.press(PointOption.point(textPrintDeSpeedTest.getLocation().x + picWidth/2,
                        textPrintDeSpeedTest.getLocation().y + textHeight + picHeight/2))
                .release()
                .perform();
        itemGallery.click();
        clickWait(firstPicture, 2);

        touchAction.longPress(PointOption.point(textPrintDeSpeedTest.getCenter()))
                .moveTo(PointOption.point(textDni.getCenter()))
                .release()
                .perform();

        touchAction.press(PointOption.point(textConformidadDeInstalacion.getLocation().x + picWidth/2,
                        textConformidadDeInstalacion.getLocation().y + textHeight + picHeight/2))
                .release()
                .perform();
        itemGallery.click();
        clickWait(firstPicture, 2);
        touchAction.press(PointOption.point(textEvidenciaDeInstallacion.getLocation().x + picWidth/2,
                        textEvidenciaDeInstallacion.getLocation().y + textHeight + picHeight/2))
                .release()
                .perform();
        itemGallery.click();
        clickWait(firstPicture, 2);

        System.out.println("Now upload button will be clicked...");

        clickWait(btnUploadPhotos, 5);
        return new StepsListScreen(driver);
    }
}
