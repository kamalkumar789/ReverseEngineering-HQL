package org.example.Entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "STD_NAME")
    private String name;
    @Column(name = "STD_FATHER_NAME")
    private String fatherName;
    @Column(name = "STD_DOB")
    private String dateOfBirth;
    @OneToOne
    private Department department;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "STUDENT_COURSE",
            joinColumns =  @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Courses> courses;
    @Column(name = "STD_UPDATED_ON")
    @UpdateTimestamp
    private Date updatedOn;
    @Column(name = "STUDENT_CREATED_ON")
    @CreationTimestamp
    private Date createdOn;
}
