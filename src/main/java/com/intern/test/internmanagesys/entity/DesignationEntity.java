package com.intern.test.internmanagesys.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.*;

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

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "designationEntity")
    private Set<InternEntity> internEntity= new SortedSet<InternEntity>() {
        @Nullable
        @Override
        public Comparator<? super InternEntity> comparator() {
            return null;
        }

        @NotNull
        @Override
        public SortedSet<InternEntity> subSet(InternEntity fromElement, InternEntity toElement) {
            return null;
        }

        @NotNull
        @Override
        public SortedSet<InternEntity> headSet(InternEntity toElement) {
            return null;
        }

        @NotNull
        @Override
        public SortedSet<InternEntity> tailSet(InternEntity fromElement) {
            return null;
        }

        @Override
        public InternEntity first() {
            return null;
        }

        @Override
        public InternEntity last() {
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

        @NotNull
        @Override
        public Iterator<InternEntity> iterator() {
            return null;
        }

        @NotNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NotNull
        @Override
        public <T> T[] toArray(@NotNull T[] a) {
            return null;
        }

        @Override
        public boolean add(InternEntity internEntity) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NotNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(@NotNull Collection<? extends InternEntity> c) {
            return false;
        }

        @Override
        public boolean retainAll(@NotNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean removeAll(@NotNull Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }
    };
}
