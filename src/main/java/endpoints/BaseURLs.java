package endpoints;

public enum BaseURLs {
    REQRESS_SERVICE("https://reqres.in");

    String url;

    BaseURLs(String url) {
        this.url = url;
    }

    public String getUrl(){
        return url;
    }
}
