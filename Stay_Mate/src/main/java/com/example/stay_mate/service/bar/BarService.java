package com.example.stay_mate.service.bar;

import com.example.stay_mate.model.bar.Bar;
import com.example.stay_mate.repository.bar.BarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarService {
    public final BarRepository barRepository;

    public BarService(BarRepository barRepository) {
        this.barRepository = barRepository;
    }

    public List<Bar> findAllBar() {
        return barRepository.findAll();
    }

    public void save(Bar bar) {
        barRepository.save(bar);
    }

    public Optional<Bar> getBarById(Integer id) {
        return barRepository.findById(id);
    }

    public void deleteBarById(Integer id) {
        barRepository.deleteById(id);
    }


    public void delete(Bar bar) {
        barRepository.delete(bar);
    }
}
