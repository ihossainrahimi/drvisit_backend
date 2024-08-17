package com.myapp.doctorvisit.rate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateRepository extends JpaRepository<Rate, Integer> {
    List<Rate> findAllByDoctorId(Integer doctorId);
}
