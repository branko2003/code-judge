package com.branko.midlevel.codejudge.constant;

public enum ContestStatusEnum {
    PENDING("pending"),
    RUNNING("running"),
    DONE("done");

    private final String value;

    ContestStatusEnum(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
