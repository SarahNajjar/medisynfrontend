package com.example.finalbackendproject.repository;

import com.example.finalbackendproject.model.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

@Repository
public interface WithdrawalRepository extends JpaRepository<Withdrawal, Integer> {

    @Query("SELECT w FROM Withdrawal w WHERE " +
            "(:doctorId IS NULL OR w.doctor.doctorId = :doctorId) AND " +
            "(:secretary IS NULL OR LOWER(w.secretary.username) LIKE LOWER(CONCAT('%', :secretary, '%'))) AND " +
            "(:date IS NULL OR w.withdrawalDate = :date)")
    List<Withdrawal> findFilteredWithdrawals(
            @Param("doctorId") Integer doctorId,
            @Param("secretary") String secretary,
            @Param("date") Date date
    );
}
