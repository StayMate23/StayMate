package com.example.stay_mate.service.bar;

import com.example.stay_mate.model.bar.Bar;
import com.example.stay_mate.repository.bar.BarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarService {
    public final BarRepository barRepository;

    public BarService(BarRepository barRepository){
        this.barRepository = barRepository;
    }
    public List<Bar> getAllBars(){return barRepository.findAll();}
}
