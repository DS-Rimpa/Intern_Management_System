package com.intern.test.internmanagesys.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="project")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Column(length = 50)
    @NotEmpty(message = "{validation.designation.NotEmpty}")
    @Size(min=2,max=30,message = "{validation.designation.Size}")
    private String projectName;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="projectEntity")
    private List<TaskEntity> taskEntity;
}
