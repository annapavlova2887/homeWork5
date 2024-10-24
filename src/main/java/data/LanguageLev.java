package data;

public enum LanguageLev {
    BEGINNER("beginner"),
    INTERMEDIATE("intermediate"),
    ADVANCED("advanced"),
    NATIVe("native");

    private final String data;

    LanguageLev(String data){
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
