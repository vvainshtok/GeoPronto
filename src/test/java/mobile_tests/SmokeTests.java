package mobile_tests;

import config.AppiumConfig;
import dto.UserDto;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.MainScreen;
import screens.StepsListScreen;

import static io.restassured.RestAssured.given;

public class SmokeTests extends AppiumConfig  {

    LoginScreen loginScreen;
    MainScreen mainScreen;
    StepsListScreen stepsListScreen;

    @BeforeMethod
    public void loginAndAcceptTask() {
        UserDto user = UserDto.builder()
                .email("mnt1")
                .password("mnt1mnt1")
                .build();
        new LoginScreen(driver)
                .typeLoginForm(user)
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

    /* @BeforeMethod
    public void sendPostRequest() {
            int i = new Random().nextInt(1000) + 1000;
            String[] macList = {"AC77830B33","77898DA889F", "66900AB78C"};
            String[] phoneSeriesList = {"314234234", "2342134134", "2431234134"};
            LocationDto location = LocationDto.builder()
                    .lat(-12.1044011)
                    .long_(-76.9731497)
                    .build();
            TestingProfileDto testingProfile = TestingProfileDto.builder()
                    .withContract(true)
                    .materialErrorsCount(0)
                    .photosErrorsCount(0)
                    .macList(macList)
                    .phoneSeriesList(phoneSeriesList)
                    .taskType("installation")
                    .build();
            RequestDto request = RequestDto.builder()
                    .source("test")
                    .client_id(3473386)
                    .customer_code("2027068"+i)
                    .group_id(1109448)
                    .first_name("Ilya")
                    .middle_name("")
                    .last_name("tre")
                    .mobile("959164868")
                    .email("sevriugin@gmail.com")
                    .location(location)
                    .installation_date("2024-11-12T08:00:00.000+03:00")
                    .contractor_name("Fu-fu")
                    .contractor_id(49)
                    .testingProfile(testingProfile)
                    .build();

            Response response = given()
                    .body(request)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Basic c2djOnNkZmo7a2oyMzQ3MHNhZGZqOktKO2FzZnUqJilhcw==")
                    .when()
                    .post("https://test.geopronto.com/api/v1/installation/" + i)
                    .thenReturn();
            System.out.println(response.getStatusCode());
            System.out.println("--> 2027068" + i);
        }

     */


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
                .selectStepPhotos()
                .uploadPhotos()
                .selectStepFinish()
                .finishTask();
    }


}
