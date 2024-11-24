package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SelectInstallationTaskScreen extends BaseScreen{
    public SelectInstallationTaskScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@text='Confirmed']")
    AndroidElement taskConfirmed;

    @FindBy(xpath = "//*[@text='In Progress']")
    AndroidElement taskInProgress;

    //@FindBy(xpath = "//*[@resource-id='com.geopronto.app.test.debug:id/step_title']")

    List<AndroidElement> taskList;
    AndroidElement firstTask;
    AndroidElement lastTask;



    public SelectInstallationTaskStartScreen selectLastTask() {
        TouchAction<?> action = new TouchAction<>(driver);
        int x = driver.manage().window().getSize().width/2;
        int yFrom = driver.manage().window().getSize().height*9/10;
        int yTo = driver.manage().window().getSize().height/2;
        for (int i = 0; i <5 ; i++) {
            action.longPress(PointOption.point(x, yFrom))
                    .moveTo(PointOption.point(x, yTo))
                    .release()
                    .perform();
        }
        taskList = driver.findElements
                (By.xpath("//*[@resource-id='com.geopronto.app.test.debug:id/step_title']"));
        lastTask = taskList.get(taskList.size()-1);
        lastTask.click();
        return new SelectInstallationTaskStartScreen(driver);
 }




    public StepsListScreen selectTaskNum(int num) {
        taskList = driver.findElements
                (By.xpath("//*[@resource-id='com.geopronto.app.test.debug:id/step_title']"));
        firstTask = taskList.get(num-1);
        firstTask.click();
        return new StepsListScreen(driver);
    }



    //TouchAction action = new TouchAction(driver);
    //    action.longPress(bottomElement).moveTo(topElement).release().perform();
}
