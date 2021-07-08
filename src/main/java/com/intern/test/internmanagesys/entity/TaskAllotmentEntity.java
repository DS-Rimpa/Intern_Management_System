package com.intern.test.internmanagesys.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name="task_allotment")
public class TaskAllotmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskAllotId;

    @Column(length = 50)
    @Size(min=2,max=300,message = "{validation.feedback.Size}")
    private String feedback;

    @NotNull(message = "{validation.ranking.NotEmpty}")
    @Min(value = 1,message = "{validation.ranking.Size}")
    @Max(value=10,message = "{validation.ranking.Size}")
    private Byte ranking;

    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "intern_id")
    private InternEntity internEntity;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private TaskEntity taskEntity;
}
