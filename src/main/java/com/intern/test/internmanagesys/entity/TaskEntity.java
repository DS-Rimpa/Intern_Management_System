package com.intern.test.internmanagesys.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name="task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(length = 50)
   // @NotEmpty(message = "{validation.taskDescription.NotEmpty}")
    @Size(min=2,max=300,message = "{validation.taskDescription.Size}")
    private String taskDescription;
}
