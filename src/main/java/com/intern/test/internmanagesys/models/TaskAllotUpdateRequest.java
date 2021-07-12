package com.intern.test.internmanagesys.models;

import com.intern.test.internmanagesys.entity.TaskStatus;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
public class TaskAllotUpdateRequest {
    private String feedback;
    private Float ranking;
    private TaskStatus taskStatus;
    private LocalDate endDate;

}
