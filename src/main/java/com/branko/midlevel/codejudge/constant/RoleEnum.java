package com.branko.midlevel.codejudge.constant;

import java.util.List;

public enum RoleEnum {
    ADMIN("admin"),
    PARTICIPANT("participant");

    private final String value;

    RoleEnum(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }

    public static boolean isAllowedRol(String rol) {
        return List.of(
                ADMIN.get(),
                PARTICIPANT.get()
        ).contains(rol);
    }
}
