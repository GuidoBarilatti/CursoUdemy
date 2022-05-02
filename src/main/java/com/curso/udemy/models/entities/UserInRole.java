package com.curso.udemy.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class UserInRole {
    @Id
    private int id;
}
