package mobile_tests;

import config.AppiumConfig;
import dto.UserDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.*;

public class StepsTests extends AppiumConfig {

    LoginScreen loginScreen;
    MainScreen mainScreen;
    SelectInstallationTaskScreen selectInstallationTaskScreen;

    @BeforeMethod
    public void login() {
        UserDto user = UserDto.builder()
                .email("mnt1")
                .password("mnt1mnt1")
                .build();
        loginScreen = new LoginScreen(driver);
        mainScreen = new MainScreen(driver);
        mainScreen =loginScreen.typeLoginForm(user)
                .clickLoginButtonSuccess()
                .allowAccessLocation()
                .allowPictures();
    }

    @Test
    public void stepsPositiveTest() {
        mainScreen.clickInstallationButton()
                .selectTaskNum(3)
                .selectStepContract()
                .uploadPhoto()
                //.selectStepNetwork() // to comment if previous uncommented!
                .selectPort01AndEnterCintillo("123")
                .selectStepMAC()
                .selectMAC()
                .selectStepTest()
                .runTest()
                .selectStepMaterials()
                .selectMaterialsForSmokeTest()
                .selectStepPhotos();
        System.out.println("Starting to upload photos...");
        PhotosScreen photosScreen = new PhotosScreen(driver);
        photosScreen.uploadPhotos();
        System.out.println("Finished to upload photos");
        StepsListScreen stepsListScreen = new StepsListScreen(driver);
        stepsListScreen.selectStepFinish()
                .finishTask();
    }
}
