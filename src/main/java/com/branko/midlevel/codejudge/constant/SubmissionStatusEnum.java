package com.branko.midlevel.codejudge.constant;

public enum SubmissionStatusEnum {
    PENDING("pending"),
    RUNNING("running"),
    DONE("done");

    private final String value;

    SubmissionStatusEnum(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }
}
