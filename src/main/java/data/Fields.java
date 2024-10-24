package data;

public enum Fields {

    NAME("#username", "Anna"),
    EMAIL("#email", "anna97@mail.ru"),
    PASSWORD("#password", "08032012"),
    PASSWORD2("#confirm_password", "08032012");

    private String locator;
    private String data;

    Fields(String locator, String date) {
        this.locator = locator;
        this.data = date;
    }
    public String getLocator() {
        return locator;
    }
    public String getData() {
        return data;
    }
}
