package com.theforest.minientrepriseit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private String title;

    private String description;

    private String dateCompletion;

    private String uid;
}
