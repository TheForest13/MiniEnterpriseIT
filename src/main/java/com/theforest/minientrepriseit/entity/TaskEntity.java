package com.theforest.minientrepriseit.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task",schema = "public")
@SequenceGenerator(schema = "public", name = "task_s", sequenceName = "public.task_s", allocationSize = 1)
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_s")
    @Column(name = "id")
    private Integer id;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_completion")
    private Date dateCompletion;

    @Column(name = "uid")
    private String uid;
}
