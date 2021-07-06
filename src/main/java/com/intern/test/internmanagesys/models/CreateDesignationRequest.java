package com.intern.test.internmanagesys.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateDesignationRequest {
    private String designationType;

}
