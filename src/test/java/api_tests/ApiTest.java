package api_tests;

import java.util.Random;
import api.ApiController;
import org.testng.annotations.Test;

public class ApiTest {

    @Test
    public void sendRequestPositiveTest() {

    int taskNum;
    taskNum = new Random().nextInt(1000) + 1000;
    ApiController.sendRequest(taskNum);

    }
}
