package com.example.stay_mate.repository.partner;

import com.example.stay_mate.model.partner.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Integer> {
    Partner findPartnerById(Integer id);
}
