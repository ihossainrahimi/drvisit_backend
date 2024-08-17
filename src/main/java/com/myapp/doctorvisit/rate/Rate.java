package com.myapp.doctorvisit.rate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;

/**
 * A Rate.
 */
@Entity
@Getter
@Setter
@Table(name = "rate")
@ToString
@RequiredArgsConstructor
public class Rate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "doctor_id")
    private Integer doctorId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "score")
    private Float score;

    @Column(name = "created_at")
    private Instant createdAt;

}
