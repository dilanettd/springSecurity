package com.autourducode.demo.service;

import com.autourducode.demo.entity.Doctor;
import com.autourducode.demo.repository.IDoctorRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@AllArgsConstructor
public class DoctorService implements IDoctorService{

    private final IDoctorRepository doctorRepository;

    @Override
    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Iterable<Doctor> gets() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor update(Long id, Doctor doctor) {
        return doctorRepository.findById(id).map(d->{
            d.setName(doctor.getName());
            d.setEmail(doctor.getEmail());
            d.setSpeciality(doctor.getSpeciality());
            return doctorRepository.save(d);
        }).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public String delete(Long id) {
        doctorRepository.deleteById(id);
        return "success";
    }

    @Override
    public Doctor get(Long id) {
        return doctorRepository.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }
}
