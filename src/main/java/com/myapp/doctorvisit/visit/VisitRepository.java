package com.myapp.doctorvisit.visit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {

    @Query("select visit from Visit visit where visit.doctorId = :doctorId and visit.isFree and visit.startedAt >= :from and visit.endAt <= :to")
    List<Visit> findAllFreeByDoctorIdAndBetweenDates(@Param("doctorId") Integer doctorId, @Param("from") LocalDateTime from, @Param("to") LocalDateTime to);

    @Query("select visit from Visit visit where visit.doctorId = :doctorId and visit.startedAt >= :from and visit.endAt <= :to")
    List<Visit> findAllByDoctorIdAndBetweenDates(@Param("doctorId") Integer doctorId, @Param("from") LocalDateTime from, @Param("to") LocalDateTime to);

    @Modifying
    @Transactional
    @Query(value = "update visit set is_free = false where is_free = true and minute(started_at) <= minute(now())", nativeQuery = true)
    void updateAllByIsFreeAndFromBeforeNow();

    @Query(value = "select visit from Visit visit where visit.doctorId = :doctorId and visit.isFree = true")
    List<Visit> findAllFreeByDoctorId(Integer doctorId);

    @Modifying
    @Transactional
    @Query(value = "update Visit visit set visit.isFree = false, visit.customerId = :customerId where visit.id = :id")
    void updateVisitAvailability(Integer id, Integer customerId);

    @Query(value = "select count(visit) from Visit visit where visit.doctorId = :doctorId and (visit.startedAt between :startedAt and :endAt or visit.endAt between :startedAt and :endAt)")
    Integer findByDoctorIdAndVisitBetweenStartAndEnd(@Param("doctorId") Integer doctorId, @Param("startedAt") LocalDateTime startedAt, @Param("endAt") LocalDateTime endAt);

    List<Visit> findAllByDoctorId(Integer doctorId);

    List<Visit> findAllByCustomerId(Integer customerId);

    @Query("select visit from Visit visit where visit.customerId = :customerId and visit.startedAt >= :from and visit.endAt <= :to")
    List<Visit> findAllByCustomerIdAndBetweenDates(Integer customerId, LocalDateTime from, LocalDateTime to);
}
