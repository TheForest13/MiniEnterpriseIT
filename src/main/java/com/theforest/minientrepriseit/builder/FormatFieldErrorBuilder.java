package com.theforest.minientrepriseit.builder;

import com.theforest.minientrepriseit.api.TypeProvider;
import com.theforest.minientrepriseit.type.EmployeeFieldNameType;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;
import java.util.Objects;

public class FormatFieldErrorBuilder {
    public static String build(String field,
                               TypeProvider typeProvider,
                               String errorMessage,
                               EmployeeFieldNameType fieldNameType) {

        if (Objects.nonNull(field) &&
                !StringUtils.isBlank(field) &&
                typeProvider.getPositions().containsKey(field)) {
            return null;
        }

        return MessageFormat.format(errorMessage, fieldNameType.getTitle());
    }
}
