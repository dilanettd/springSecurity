package com.autourducode.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Appointment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @ManyToOne
    private User user;
    @ManyToOne
    private Doctor doctor;
    @OneToOne
    private Consultation consultation;


        public Appointment(Date date, User user, Doctor doctor) {
            this.date = date;
            this.user = user;
            this.doctor = doctor;
        }
}
