package com.example.stay_mate.service;

import com.example.stay_mate.model.Partner;
import com.example.stay_mate.repository.PartnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PartnerService {
    private final PartnerRepository partnerRepository;

    public PartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    public void savePartner(Partner partner) {
        partnerRepository.save(partner);
    }

   @Transactional
    public void deletePartner(Integer id) {
        partnerRepository.removeById(id);
    }

    public List<Partner> findAllPartner() {
        return partnerRepository.findAll();
    }

    public Partner getPartnerById(Integer id) {
        return partnerRepository.findPartnerById(id);
    }

}
