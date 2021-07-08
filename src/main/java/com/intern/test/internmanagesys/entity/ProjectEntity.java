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
@Table(name="project")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Column(length = 50)
    @NotEmpty(message = "{validation.designation.NotEmpty}")
    @Size(min=2,max=30,message = "{validation.designation.Size}")
    private String projectName;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="projectEntity")
    private Set<TaskEntity> taskEntity= new SortedSet<TaskEntity>() {
        @Nullable
        @Override
        public Comparator<? super TaskEntity> comparator() {
            return null;
        }

        @NotNull
        @Override
        public SortedSet<TaskEntity> subSet(TaskEntity fromElement, TaskEntity toElement) {
            return null;
        }

        @NotNull
        @Override
        public SortedSet<TaskEntity> headSet(TaskEntity toElement) {
            return null;
        }

        @NotNull
        @Override
        public SortedSet<TaskEntity> tailSet(TaskEntity fromElement) {
            return null;
        }

        @Override
        public TaskEntity first() {
            return null;
        }

        @Override
        public TaskEntity last() {
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
        public Iterator<TaskEntity> iterator() {
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
        public boolean add(TaskEntity taskEntity) {
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
        public boolean addAll(@NotNull Collection<? extends TaskEntity> c) {
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
