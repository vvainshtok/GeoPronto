package mobile_tests;

import config.AppiumConfig;
import dto.UserDto;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class LoginTest extends AppiumConfig {

    @Test
    public void loginPositiveTest() {
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

}
