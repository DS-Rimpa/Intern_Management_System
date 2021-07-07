package com.intern.test.internmanagesys.models;


import lombok.*;
import org.springframework.web.bind.annotation.ModelAttribute;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
public class CreateDesignationRequest {
    private String designationType;

}
