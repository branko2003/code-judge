package com.branko.midlevel.codejudge.constant;

public enum LanguageEnum {

    JAVA("java"),
    PYTHON("python"),
    JAVASCRIPT("javascript");

    private final String value;

    LanguageEnum(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }

}
