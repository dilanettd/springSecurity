package com.autourducode.demo.repository;

import com.autourducode.demo.entity.Consultation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConsultationRepository extends CrudRepository<Consultation,Long> {
}
