package test_data;

public enum Urls {
    WIKIPEDIA_MAIN_PAGE("https://www.wikipedia.org/");

    private final String url;

    Urls(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
