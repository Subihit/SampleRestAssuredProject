package domain;

import io.restassured.response.Response;
import org.testng.Assert;

public class Users {

    public void verifyName(Response response, String expectedName) {
        System.out.println("Verify Name is " + expectedName);
        Assert.assertEquals(response.getBody().jsonPath().get("name"), expectedName);
    }

    public void verifyJob(Response response, String expectedName) {
        System.out.println("Verify job is " + expectedName);
        Assert.assertEquals(response.getBody().jsonPath().get("job"), expectedName);
    }

}
