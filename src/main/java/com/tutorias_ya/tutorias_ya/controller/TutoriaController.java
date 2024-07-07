package com.tutorias_ya.tutorias_ya.controller;

import com.tutorias_ya.tutorias_ya.repository.Profesor;
import com.tutorias_ya.tutorias_ya.repository.Tutoria;
import com.tutorias_ya.tutorias_ya.service.TutoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutoria")
public class TutoriaController {
    @Autowired
    private TutoriaService ts;

    @GetMapping("/tutorias/{student}")
    public List<Tutoria> tutorias(@PathVariable String student){
        return ts.tutorias(student);
    }

    @PostMapping("/agendar")
    public String agendar(@RequestBody Tutoria t){
        return ts.agendarTutoria(t);
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestBody Tutoria t){
        return ts.eliminarTutoria(t);
    }

    @PostMapping("/profesor")
    public String profesor(@RequestBody Profesor p){
        return ts.addProfesor(p);
    }

    @GetMapping("/profesores")
    public List<Profesor> profesores(){
        return ts.profesores();
    }
}
