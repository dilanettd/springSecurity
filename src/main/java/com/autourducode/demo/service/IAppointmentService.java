package com.autourducode.demo.service;

import com.autourducode.demo.entity.Appointment;
import com.autourducode.demo.model.AppointmentForm;

public interface IAppointmentService {
    Appointment create(AppointmentForm appointmentForm, Long idUser, Long idDoctor);

    Iterable<Appointment> gets();

    Appointment update(Long id, Appointment appointment);

    String delete(Long id);

    Appointment get(Long id);
}
