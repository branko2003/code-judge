package com.branko.midlevel.codejudge.constant;

import java.util.List;

public enum JudgeLanguageStrategyName {

    JAVA("java"),
    PYTHON("python"),
    JAVASCRIPT("javascript");

    private final String value;

    JudgeLanguageStrategyName(String value) {
        this.value = value;
    }

    public String get() {
        return value;
    }

    public static boolean isAllowedLanguage(String language) {
        return List.of(
                PYTHON.get(),
                JAVA.get(),
                JAVASCRIPT.get()
        ).contains(language);
    }
}
