package com.example.stay_mate.service;

import com.example.stay_mate.model.Partner;
import com.example.stay_mate.model.PartnerAdmin;
import com.example.stay_mate.repository.PartnerAdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerAdminService {
    private final PartnerAdminRepository partnerAdminRepository;

    public PartnerAdminService(PartnerAdminRepository partnerAdminRepository) {
        this.partnerAdminRepository = partnerAdminRepository;
    }

    public void savePartnerAdmin(PartnerAdmin partnerAdmin) {
        partnerAdminRepository.save(partnerAdmin);
    }

    public List<PartnerAdmin> findAllPartnerAdmins() {
        return partnerAdminRepository.findAll();
    }

    public List<PartnerAdmin> getAllPartnerAdminByPartner(Partner partner) {
        return partnerAdminRepository.getPartnerAdminByPartner(partner);
    }

    public PartnerAdmin getPartnerAdminById(Integer id) {
        return partnerAdminRepository.findById(id).orElse(null);
    }
}
