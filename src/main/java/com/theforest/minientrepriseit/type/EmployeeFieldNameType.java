package com.theforest.minientrepriseit.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmployeeFieldNameType {
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    POSITION("position"),
    CURRENT_EMP("currentEmp");

    private final String title;
}
