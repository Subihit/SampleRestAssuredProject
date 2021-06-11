package reqresServiceTests;

import base.BaseTest;
import domain.Users;
import endpoints.HTTPMethod;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import services.RegresService;

import static base.CommonTest.*;
import static io.restassured.RestAssured.given;

public class ListUsersTest extends BaseTest {

    Users users = new Users();

    @Test
    public void getUsers() {

        Response getUsersResponse = sendRequest(HTTPMethod.GET
                , RegresService.getUserURI(2));
        verifyResponseTime(getUsersResponse, 5000);
        verifyStatusCode(getUsersResponse, 200);
    }

    @Test
    public void addUser() {
        String testNameParam = "test Name", testJobParam = "test Job";

        String payload = getPayLoad("addUser.json");
        payload = payload.replace("NAME_PARAM", testNameParam).
                replace("JOB_PARAM", testJobParam);

//        String endpoint = "/api/users";
//        String URI = baseURI + endpoint;
//        System.out.println("URI : " + URI);

        Response response = given().header("content-type", "application/json")
                .and().body(payload).
                        when().post(RegresService.postAddUserURI());

        System.out.println("Response body : ");
        response.then().log().body();

        users.verifyName(response, testNameParam);
        users.verifyJob(response, testJobParam);
    }

}

