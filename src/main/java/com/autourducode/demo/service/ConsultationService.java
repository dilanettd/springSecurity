package com.autourducode.demo.service;

import com.autourducode.demo.entity.Consultation;
import com.autourducode.demo.repository.IConsultationRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class ConsultationService implements IConsultationService{

    private final IConsultationRepository consultationRepository;

    @Override
    public Consultation create(Consultation consultation) {
        return null;
    }

    @Override
    public Iterable<Consultation> gets() {
        return null;
    }

    @Override
    public Consultation update(Long id, Consultation consultation) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public Consultation get(Long id) {
        return null;
    }
}
