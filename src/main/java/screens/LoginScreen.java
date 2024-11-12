package screens;

import dto.UserDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;
import org.testng.reporters.jq.Main;

public class LoginScreen extends BaseScreen{
    public LoginScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.geopronto.app.test.debug:id/username")
    AndroidElement inputEmail;
    @FindBy(id = "com.geopronto.app.test.debug:id/password")
    AndroidElement inputPassword;
    @FindBy(id = "com.geopronto.app.test.debug:id/login")
    AndroidElement btnLogin;








    public LoginScreen typeLoginForm(UserDto user) {
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
        return this;
    }

    public MainScreen clickLoginButtonSuccess() {
        btnLogin.click();
        return  new MainScreen(driver);
    }


}
