package com.example.stay_mate.service.owner;

import com.example.stay_mate.model.owner.Owner;
import com.example.stay_mate.repository.owner.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    public final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public void saveOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    public List<Owner> findAllOwnerAdmins() {
        return ownerRepository.findAll();
    }


    public Owner getOwnerById(Integer id) {
        return ownerRepository.getReferenceById(id);
    }
}
