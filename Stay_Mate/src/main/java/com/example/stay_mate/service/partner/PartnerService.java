package com.example.stay_mate.service.partner;

import com.example.stay_mate.model.partner.Partner;
import com.example.stay_mate.repository.partner.PartnerRepository;
import org.springframework.stereotype.Service;

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

    public List<Partner> findAllPartner() {
        return partnerRepository.findAll();
    }

    public Partner getPartnerById(Integer id) {
        return partnerRepository.findPartnerById(id);
    }

}
