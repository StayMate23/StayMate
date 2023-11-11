package com.example.stay_mate.repository.bar;

import com.example.stay_mate.model.bar.Bar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarRepository extends JpaRepository<Bar,Integer> {
}
