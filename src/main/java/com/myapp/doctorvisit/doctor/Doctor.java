package com.myapp.doctorvisit.doctor;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;
    private int professionalId;
    private String title;


    @Column(nullable = false, columnDefinition = "int default 0")
    private long visitFee;

    @Column(nullable = false, columnDefinition = "float default 0")
    private float companyPercent;
    private String city;

    private String visitRules;
    private String officePhoneNumber;
    private String officeAddress;

    @Type(JsonType.class)
    @Column(name = "description", columnDefinition = "json")
    private String description;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
