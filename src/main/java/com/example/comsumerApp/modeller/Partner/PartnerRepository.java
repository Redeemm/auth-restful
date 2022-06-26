package com.example.comsumerApp.modeller.Partner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PartnerRepository extends JpaRepository<Partner, Long> {

    @Query("SELECT s FROM Student s WHERE s.partnerName = ?1")
    Optional<Partner> findStudentByEmail(String firstName);

}
