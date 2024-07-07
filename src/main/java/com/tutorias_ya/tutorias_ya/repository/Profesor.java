package com.tutorias_ya.tutorias_ya.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "profesor")
public class Profesor {
    @Id
    private String id;
    private String nombre;
    private String materia;
}
