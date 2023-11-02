package com.example.stay_mate.service.owner;

import com.example.stay_mate.repository.owner.OwnerAdminRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerAdminService {
    public final OwnerAdminRepository ownerAdminRepository;


    public OwnerAdminService(OwnerAdminRepository ownerAdminRepository) {
        this.ownerAdminRepository = ownerAdminRepository;
    }
}
