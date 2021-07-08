package com.intern.test.internmanagesys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name="intern")
public class InternEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @NotEmpty(message = "CANNOT BE NULL")
    private String name;

    private Float salary;


    @Column(name = "contact", nullable = false)
    @NotNull(message = "CANNOT BE NULL")
    @Positive(message = "POSITIVE ACCEPTED")
    private Long contact;

    @Column(name = "address", nullable = false)
    @NotNull(message = "{validation.address.NotNull}")
    private String address;

    @Column(name = "postal_code", nullable = false)
    @NotNull(message = "{validation.postalCode.NotNull}")
    private String postalCode;

    @Column(name = "start_date")
//    @CreationTimestamp
//    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(name = "end_date", nullable = true)
//    @UpdateTimestamp
//    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;


    @Enumerated(EnumType.STRING)
    private StatusType status;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "designation_id")
    private DesignationEntity designationEntity;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "internEntity")
    private List<TaskAllotmentEntity> taskAllotmentEntity;

}
