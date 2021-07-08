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
    private Set<TaskAllotmentEntity> taskAllotmentEntity= new SortedSet<TaskAllotmentEntity>() {
        @Nullable
        @Override
        public Comparator<? super TaskAllotmentEntity> comparator() {
            return null;
        }

        @org.jetbrains.annotations.NotNull
        @Override
        public SortedSet<TaskAllotmentEntity> subSet(TaskAllotmentEntity fromElement, TaskAllotmentEntity toElement) {
            return null;
        }

        @org.jetbrains.annotations.NotNull
        @Override
        public SortedSet<TaskAllotmentEntity> headSet(TaskAllotmentEntity toElement) {
            return null;
        }

        @org.jetbrains.annotations.NotNull
        @Override
        public SortedSet<TaskAllotmentEntity> tailSet(TaskAllotmentEntity fromElement) {
            return null;
        }

        @Override
        public TaskAllotmentEntity first() {
            return null;
        }

        @Override
        public TaskAllotmentEntity last() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @org.jetbrains.annotations.NotNull
        @Override
        public Iterator<TaskAllotmentEntity> iterator() {
            return null;
        }

        @org.jetbrains.annotations.NotNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @org.jetbrains.annotations.NotNull
        @Override
        public <T> T[] toArray(@org.jetbrains.annotations.NotNull T[] a) {
            return null;
        }

        @Override
        public boolean add(TaskAllotmentEntity taskAllotmentEntity) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@org.jetbrains.annotations.NotNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(@org.jetbrains.annotations.NotNull Collection<? extends TaskAllotmentEntity> c) {
            return false;
        }

        @Override
        public boolean retainAll(@org.jetbrains.annotations.NotNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean removeAll(@org.jetbrains.annotations.NotNull Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }
    };

}
