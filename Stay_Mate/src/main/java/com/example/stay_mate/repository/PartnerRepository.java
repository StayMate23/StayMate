package com.example.stay_mate.repository;

import com.example.stay_mate.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer> {
    Partner findPartnerById(Integer id);
}
