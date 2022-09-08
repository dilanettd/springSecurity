package com.autourducode.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String email;
    @Column(length = 50)
    private String speciality;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Collection<Appointment> appointments = new ArrayList<>();
}
