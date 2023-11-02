package com.example.stay_mate.repository.owner;

import com.example.stay_mate.model.owner.OwnerAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerAdminRepository extends JpaRepository<OwnerAdmin, Integer> {
}
