package com.intern.test.internmanagesys.models;

import com.intern.test.internmanagesys.entity.StatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.internal.build.AllowSysOut;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateInternRequest {

    private String name;

    private Long contact;

    private String address;

    private String postalCode;

    private Float salary;


}
