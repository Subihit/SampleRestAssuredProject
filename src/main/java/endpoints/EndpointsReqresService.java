package endpoints;

public enum EndpointsReqresService {
    LIST_USERS("/api/users?page=PAGE-PARAM"),
    SINGLE_USER("/api/users?page=PAGE_PARAM"),
    CREATE_USER("/api/users");

    String endpoint;

    EndpointsReqresService(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint(){
        return endpoint;
    }
}
