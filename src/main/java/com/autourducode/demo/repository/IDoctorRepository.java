package com.autourducode.demo.repository;

import com.autourducode.demo.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepository extends CrudRepository<Doctor, Long> {
}
