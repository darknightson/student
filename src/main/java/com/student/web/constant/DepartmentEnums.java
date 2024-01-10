package com.student.web.constant;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum DepartmentEnums {

    DEPT01("빅데이터학과"),
    DEPT02("디자인학과");
    private final String description;

    DepartmentEnums(String description) {
        this.description = description;
    }

    public static DepartmentEnums find(String name) {
        return Arrays.stream(values())
                .filter(s -> s.name().equals(name))
                .findAny()
                .orElse(null);
    }
}
