package com.tutorias_ya.tutorias_ya.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TutoriaRepository extends MongoRepository<Tutoria, String> {
    List<Tutoria> findByStudent(String student);

    List<Tutoria> findByProfesorAndMesAndDiaAndHora(String profesor, int mes, int dia, int hora);

    void delete(Tutoria tu);
}
