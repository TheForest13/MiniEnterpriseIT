package com.theforest.minientrepriseit.builder;

import com.theforest.minientrepriseit.type.EmployeeFieldNameType;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;
import java.util.Objects;

public class EmptyFieldErrorBuilder {
    public static String build(String field,
                               String errorMessage,
                               EmployeeFieldNameType fieldNameType) {
        switch (fieldNameType) {
            case FIRST_NAME:
            case LAST_NAME:
            case POSITION:
                if (Objects.nonNull(field) && !StringUtils.isBlank(field)) {
                    return null;
                }
                break;
        }
        return MessageFormat.format(errorMessage, fieldNameType.getTitle());
}

    public static String build(Boolean field,
                               String errorMessage,
                               EmployeeFieldNameType fieldNameType) {
        if (Objects.nonNull(field)) {
            return null;
        }
        return MessageFormat.format(errorMessage, fieldNameType.getTitle());
    }
}
