package api;

import dto.RequestDto;
import interfaces.BaseApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Controller implements BaseApi {

    protected Response addNewCarResponse(RequestDto request, String token) {
        return given()
                .body(request)
                .contentType(ContentType.JSON)
                .when()
                .post(BASE_URL)
                .thenReturn();
    }
}
