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
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "CRC_NAME")
    private String courseName;
    @Column(name = "CRC_CODE")
    private String courseCode;
    @Column(name = "CRC_UPDATE_ON")
    @UpdateTimestamp
    private Date updatedOn;
    @Column(name = "CRC_CREATED_ON")
    @CreationTimestamp
    private Date createdOn;
}