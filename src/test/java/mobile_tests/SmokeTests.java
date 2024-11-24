package mobile_tests;

import config.AppiumConfig;
import dto.UserDto;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.MainScreen;
import screens.PhotosScreen;
import screens.StepsListScreen;

public class SmokeTests extends AppiumConfig {

    LoginScreen loginScreen;
    MainScreen mainScreen;

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
                .allowPictures()
                .clickMenuButton()
                .clickReloadButton()
                .clickOngoingEventsButton()
                .clickExpandCollapseButton()
                .clickEvent()
                .acceptFirstTimeSlot();;
    }

    @Test
    public void smokeTest() {
        mainScreen.clickInstallationButton()
                .selectLastTask()
                .clickBtnStart()
                .clickBtnSkip()
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
