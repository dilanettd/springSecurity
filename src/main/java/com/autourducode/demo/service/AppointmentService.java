package com.autourducode.demo.service;

import com.autourducode.demo.entity.Appointment;
import com.autourducode.demo.entity.Doctor;
import com.autourducode.demo.entity.User;
import com.autourducode.demo.model.AppointmentForm;
import com.autourducode.demo.repository.IAppointmentRepository;
import com.autourducode.demo.repository.IConsultationRepository;
import com.autourducode.demo.repository.IDoctorRepository;
import com.autourducode.demo.repository.IUserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@Service
public class AppointmentService implements IAppointmentService{

    private final IAppointmentRepository appointmentRepository;

    private final IUserRepository userRepository;

    private final IDoctorRepository doctorRepository;

    private final IConsultationRepository consultationRepository;

    @Override
    public Appointment create(AppointmentForm appointmentForm, Long idUser, Long idDoctor) {
        User user = userRepository.findById(idUser).orElse(null);
        Doctor doctor = doctorRepository.findById(idDoctor).orElse(null);
        if(user!=null && doctor!=null){
            Appointment appointment1 = new Appointment(new Date(),user,doctor);
            return appointment1;
        }
        return null;
    }

    @Override
    public Iterable<Appointment> gets() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment update(Long id, Appointment appointment) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public Appointment get(Long id) {
        return null;
    }
}
