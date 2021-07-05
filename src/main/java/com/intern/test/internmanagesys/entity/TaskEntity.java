package com.intern.test.internmanagesys.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;

    @Column(length = 50)
   // @NotEmpty(message = "{validation.taskDescription.NotEmpty}")
    @Size(min=2,max=30,message = "{validation.taskDescription.Size}")
    private String taskDescription;
}
