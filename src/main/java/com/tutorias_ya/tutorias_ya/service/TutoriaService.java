package com.tutorias_ya.tutorias_ya.service;

import com.tutorias_ya.tutorias_ya.repository.Profesor;
import com.tutorias_ya.tutorias_ya.repository.ProfesorRepository;
import com.tutorias_ya.tutorias_ya.repository.Tutoria;
import com.tutorias_ya.tutorias_ya.repository.TutoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutoriaService {
    @Autowired
    private ProfesorRepository pr;
    @Autowired
    private TutoriaRepository tr;

    public String addProfesor(Profesor p){
        try{
            pr.save(p);
            return "OK: Profesor agregado";
        } catch (Exception e){
            return "NO: Profesor no agregado";
        }
    }

    public List<Profesor> profesores(){
        return pr.findAll();
    }

    public List<Tutoria> tutorias(String student){
        return tr.findByStudent(student);
    }

    public boolean isAvailable(Tutoria t){
        return tr.findByProfesorAndMesAndDiaAndHora(t.getProfesor(), t.getMes(), t.getDia(), t.getHora()).isEmpty();
    }

    public String agendarTutoria(Tutoria t){
        if(t.validateDate()){
            Optional<Profesor> p = pr.findById(t.getProfesor());
            if (p.isPresent()){
                if (isAvailable(t)){
                    tr.save(t);
                    return "OK: Tutoría agendad con éxito";
                }
                return "NO: El profesor no está disponible";
            }
            return "NO: Profesor no existe";
        }
        return "NO: Horario inválido, condiciones: 12 >= mes >= 1, 31 >= dia >= 1, 13 >= hora >= 8";
    }

    public String eliminarTutoria(Tutoria t){
        Optional<Tutoria> tu = tr.findById(t.getId());
        if (tu.isPresent()){
            tr.delete(tu.get());
            return "OK: Tutoría eliminada";
        }
        return "NO: Tutoría no existe";
    }
}
