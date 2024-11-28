package mobile_tests;

import config.AppiumConfig;
import dto.UserDto;
import org.testng.annotations.Test;
import screens.LoginScreen;

import static utils.PropertiesReader.getProperty;

public class LoginTests extends AppiumConfig {

    @Test
    public void loginPositiveTest() {
        UserDto user = UserDto.builder()
                .email(getProperty("data.properties","mobileLogin"))
                .password(getProperty("data.properties","mobilePassword"))
                .build();
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(user)
                .clickLoginButtonSuccess()
                .allowAccessLocation()
                .allowPictures();
    }
}
