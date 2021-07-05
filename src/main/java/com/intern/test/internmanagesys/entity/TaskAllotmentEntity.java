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
@Table(name="TaskAllotment")
public class TaskAllotmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskAllotId;

    @Column(length = 50)
   // @NotEmpty(message = "{validation.feedback.NotEmpty}")
    @Size(min=2,max=30,message = "{validation.feedback.Size}")
    private String feedback;

   // @NotEmpty(message = "{validation.ranking.NotEmpty}")
    @Size(min=1,max=10,message = "{validation.ranking.Size}")
    private int ranking;

    private String startDate;
    private String endDate;
}
