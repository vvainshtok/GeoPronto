package mobile_tests;

import config.AppiumConfig;
import dto.UserDto;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.MainScreen;

public class AcceptTaskTests extends AppiumConfig {

    @BeforeMethod
    public void login() {
        UserDto user = UserDto.builder()
                .email("mnt1")
                .password("mnt1mnt1")
                .build();
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(user)
                .clickLoginButtonSuccess()
                .allowAccessLocation()
                .allowPictures();
    }

    @Test
    public void acceptNewTaskPositiveTest() {
        MainScreen mainScreen = new MainScreen(driver);
        Assert.assertTrue(mainScreen.clickMenuButton()
                .clickReloadButton()
                .clickOngoingEventsButton()
                .clickExpandCollapseButton()
                .clickEvent()
                .acceptFirstTimeSlot()
                .clickInstallationButton()
                .isConfirmedTaskPresent());
    }
}
