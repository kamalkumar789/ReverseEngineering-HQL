package org.example.Entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "TEA_NAME")
    private String name;
    @Column(name = "TEA_DESIGNATION")
    private String designation;
    @Column(name = "STD_UPDATED_ON")
    @UpdateTimestamp
    private Date updatedOn;
    @OneToOne
    private Department department;
    @Column(name = "STUDENT_CREATED_ON")
    @CreationTimestamp
    private Date createdOn;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Teacher_courses", joinColumns =  @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Courses> courses;
}
