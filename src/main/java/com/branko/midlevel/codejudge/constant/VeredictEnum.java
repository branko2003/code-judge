package com.branko.midlevel.codejudge.constant;

public enum VeredictEnum {
    ACCEPTED("accepted"),
    WRONG_ANSWER("wrong_answer"),
    COMPILATION_ERROR("compilation_error"),
    RUNTIME_ERROR("runtime_error"),
    TIME_LIMIT_EXCEEDED("time_limit_exceeded"),
    PENDING("pending");

    private final String value;

    VeredictEnum(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
