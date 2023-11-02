package com.example.stay_mate.service.owner;

import com.example.stay_mate.repository.owner.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    public final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }
}
