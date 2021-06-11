package endpoints;

public enum Endpoints {
    LIST_USERS("/api/users?page=PAGE-PARAM"),
    SINGLE_USER("/api/users?page=PAGE_PARAM"),
    CREATE_USER("/api/users");

    String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint(){
        return endpoint;
    }
}
