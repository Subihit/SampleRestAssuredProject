package services;

import endpoints.BaseURLs;

import static endpoints.EndpointsReqresService.CREATE_USER;
import static endpoints.EndpointsReqresService.LIST_USERS;
import static utils.Logger.logURL;

public class ReqresService {

    private static String getBaseURL() {
        return BaseURLs.REQRESS_SERVICE.getUrl();
    }

    public static String getUserURI(int pageNumber) {
        String URI = getBaseURL() + LIST_USERS.getEndpoint();
        URI = URI.replace("PAGE-PARAM", Integer.toString(pageNumber));
        logURL(URI);

        return URI;
    }

    public static String postAddUserURI() {
        String URI = getBaseURL() + CREATE_USER.getEndpoint();
        logURL(URI);

        return URI;
    }

}
