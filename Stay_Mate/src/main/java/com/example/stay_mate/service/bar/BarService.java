package com.example.stay_mate.service.bar;

import com.example.stay_mate.model.bar.Bar;
import com.example.stay_mate.model.hotel.Hotel;
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
    public Object findAllBar() {
        return barRepository.findAll();
    }

    public void save(Bar bar) {
        barRepository.save(bar);
    }

    public Bar getBarById(Integer id) {
        return barRepository.getReferenceById(id);
    }

    public void deleteBarById(Integer id) {
        barRepository.deleteById(id);
    }

}
