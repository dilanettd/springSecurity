package com.autourducode.demo.service;

import com.autourducode.demo.entity.Consultation;

public interface IConsultationService {
    Consultation create(Consultation consultation);

    Iterable<Consultation> gets();

    Consultation update(Long id, Consultation consultation);

    String delete(Long id);

    Consultation get(Long id);
}
