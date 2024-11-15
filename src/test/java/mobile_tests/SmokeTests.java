package mobile_tests;

import config.AppiumConfig;
import dto.UserDto;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.MainScreen;

public class SmokeTests extends AppiumConfig {

    @BeforeMethod
    public void login() {
        UserDto user = UserDto.builder()
                .email("mnt1")
                .password("mnt1mnt1")
                .build();
        LoginScreen loginScreen = new LoginScreen(driver);
        MainScreen mainScreen = loginScreen.typeLoginForm(user)
                .clickLoginButtonSuccess();
        mainScreen.allowAccessLocation()
                .allowPictures();
    }

    @BeforeMethod
    public void acceptNewTask() {
        MainScreen mainScreen = new MainScreen(driver);
        mainScreen.clickMenuButton()
                .clickReloadButton()
                .clickOngoingEventsButton()
                .clickExpandCollapseButton()
                .clickEvent()
                .acceptFirstTimeSlot();
    }

    @Test
    public void smokeTest() {
        MainScreen mainScreen = new MainScreen(driver);
        mainScreen.clickInstallationButton();

    }


}
