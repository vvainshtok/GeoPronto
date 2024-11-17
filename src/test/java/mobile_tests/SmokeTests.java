package mobile_tests;

import config.AppiumConfig;
import dto.UserDto;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.MainScreen;

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
        // mainScreen = new MainScreen(driver);
        mainScreen.clickInstallationButton()
                .selectConfirmedTaskFirstTime()
                .clickBtnStart()
                .clickBtnSkip()
                .selectStepContract();

    }


}
