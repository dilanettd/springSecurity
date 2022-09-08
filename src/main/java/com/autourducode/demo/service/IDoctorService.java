package com.autourducode.demo.service;

import com.autourducode.demo.entity.Doctor;

public interface IDoctorService {
    Doctor create(Doctor doctor);

    Iterable<Doctor> gets();

    Doctor update(Long id, Doctor doctor);

    String delete(Long id);

    Doctor get(Long id);
}
