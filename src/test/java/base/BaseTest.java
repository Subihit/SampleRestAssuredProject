package base;

import org.testng.annotations.BeforeSuite;

import static endpoints.BaseURLs.REQRESS_SERVICE;

public class BaseTest {

    String reqresBaseURL;

    @BeforeSuite
    public void setup() {
        reqresBaseURL = REQRESS_SERVICE.getUrl();
    }
}
