package com.intern.test.internmanagesys.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
public class InternUpdateRequest {

    private String name;

    private Long contact;

    private String address;

    private String postalCode;

    private Float salary;
}
