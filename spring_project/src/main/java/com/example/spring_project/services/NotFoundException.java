package com.example.spring_project.services;

public class NotFoundException extends Throwable {
    public NotFoundException(String petNotFound) {
        super(petNotFound);
    }
}
