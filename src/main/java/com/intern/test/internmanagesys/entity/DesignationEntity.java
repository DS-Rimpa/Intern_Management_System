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
@Table(name="Designation")
public class DesignationEntity {
    @Id
    @Column(name = "designation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long designationId;

    @Column(name = "designation_type",length = 50)
   // @NotEmpty(message = "{validation.designation.NotEmpty}")
    @Size(min=2,max=30,message = "{validation.designation.Size}")
    private String designationType;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "designationEntity")
    private InternEntity internEntity;
}
