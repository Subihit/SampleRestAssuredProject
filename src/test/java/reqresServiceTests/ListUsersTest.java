package reqresServiceTests;

import base.BaseTest;
import domain.Users;
import endpoints.HTTPMethod;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import services.ReqresService;

import static base.CommonTest.verifyResponseTime;
import static base.CommonTest.verifyStatusCode;
import static endpoints.HTTPMethod.POST;
import static utils.Payload.getPayloadCreateUserAPI;
import static utils.Request.sendRequest;

public class ListUsersTest extends BaseTest {

    Users users = new Users();

    @Test
    public void getUsers() {

        Response getUsersResponse = sendRequest(HTTPMethod.GET
                , ReqresService.getUserURI(2));

        verifyResponseTime(getUsersResponse, 5000);
        verifyStatusCode(getUsersResponse, 200);
    }

    @Test
    public void addUser() {
        String testNameParam = "test Name", testJobParam = "test Job";

        String payload = getPayloadCreateUserAPI(testNameParam, testJobParam);

        Response addUsersResponse = sendRequest(POST
                , ReqresService.postAddUserURI(), payload);

        users.verifyName(addUsersResponse, testNameParam);
        users.verifyJob(addUsersResponse, testJobParam);
    }

}

