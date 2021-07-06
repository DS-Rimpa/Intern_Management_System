package com.intern.test.internmanagesys.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="designation")
public class DesignationEntity {
    @Id
    @Column(name = "designation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long designationId;

    @Column(name = "designation_type",length = 50)
    @NotEmpty(message = "Cannot be empty")
    private String designationType;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "designationEntity")
    private InternEntity internEntity;
}
