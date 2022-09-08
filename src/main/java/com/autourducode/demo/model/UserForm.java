package com.autourducode.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserForm {
    private String name;
    private String email;
    private String password;
    private String role;
}
