package com.myapp.doctorvisit.visit;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A Visit.
 */
@Data
@Entity
@ToString
@Table(name = "visit")
public class Visit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "doctor_id")
    private Integer doctorId;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "startedAt")
    private LocalDateTime startedAt;

    @Column(name = "endAt")
    private LocalDateTime endAt;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "isFree")
    private Boolean isFree;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
