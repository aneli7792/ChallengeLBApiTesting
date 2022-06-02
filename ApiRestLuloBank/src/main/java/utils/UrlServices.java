package utils;

public enum UrlServices {
    URL_SERVICES("http://dummy.restapiexample.com/"),
    LIST_EMPLOYEES("api/v1/employees"),
    SAVE_EMPLOYEE("api/v1/create"),
    DELETE_EMPLOYEE("api/v1/delete/"),
    SELECT_EMPLOYEE("api/v1/employee/");
    private final String uri;
    UrlServices(String uri) {
        this.uri = uri;
    }
    @Override
    public String toString() {
        return uri;
    }
}
