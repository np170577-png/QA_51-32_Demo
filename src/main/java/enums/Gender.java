package enums;

public enum Gender {
    MALE("gender-radio-1"),
    FEMALE("gender-radio-2"),
    OTHER("gender-radio-3");

    private String locator;

    Gender(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
