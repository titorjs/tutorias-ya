package com.tutorias_ya.tutorias_ya.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "tutoria")
public class Tutoria {
    @Id
    private String id;
    private String profesor;
    private String student;
    private int mes;
    private int dia;
    private int hora;

    public boolean validateDate(){
        if (mes < 1 || mes > 12)
            return false;
        if (dia < 1 || dia > 31)
            return false;
        if (hora < 8 || hora > 13)
            return false;
        return true;
    }
}
