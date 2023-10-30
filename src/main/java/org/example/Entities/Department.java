package org.example.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DEPT_NAME")
    private String departmentName;
    @Column(name = "DEPT_UPDATED_ON")
    @UpdateTimestamp
    private Date updatedOn;
    @Column(name = "DEPT_CREATED_ON")
    @CreationTimestamp
    private Date createdOn;
}

