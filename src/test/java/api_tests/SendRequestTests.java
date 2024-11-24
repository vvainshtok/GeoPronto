package api_tests;

import dto.LocationDto;
import dto.RequestDto;
import dto.TestingProfileDto;
import interfaces.BaseApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class SendRequestTests implements BaseApi {

    @Test
    public void sendRequestTest() {
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
                .post(BASE_URL + i)
                .thenReturn();
        System.out.println(response.getStatusCode());
        System.out.println("--> 2027068" + i);
        }
}
