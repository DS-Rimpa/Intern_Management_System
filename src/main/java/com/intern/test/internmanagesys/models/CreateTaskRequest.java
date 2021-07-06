package com.intern.test.internmanagesys.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
public class CreateTaskRequest {
    private String taskDescription;
}
