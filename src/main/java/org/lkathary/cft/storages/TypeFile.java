package org.lkathary.cft.storages;

public enum TypeFile {
    INTEGER_FILE("integer.txt"),
    FLOAT_FILE("float.txt"),
    STRING_FILE("string.txt");

    private final String title;

    TypeFile(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
