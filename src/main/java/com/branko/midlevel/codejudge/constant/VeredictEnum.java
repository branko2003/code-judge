package com.branko.midlevel.codejudge.constant;

public enum VeredictEnum {
    ACCEPTED("accepted"),
    WRONG_ANSWER("wrong answer"),
    COMPILATION_ERROR("compilation error"),
    RUNTIME_ERROR("runtime error");

    private final String value;

    VeredictEnum(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
