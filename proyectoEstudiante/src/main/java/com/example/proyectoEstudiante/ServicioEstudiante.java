package com.example.proyectoEstudiante;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioEstudiante {
    private List<Estudiante> estudiantes;

    public ServicioEstudiante() {
        estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante(10, "Ana", "Salazar", "sexto", 4.5F, 3.9F, 4.2F));
        estudiantes.add(new Estudiante(11, "Lina", "Daza", "septimo", 4.0F, 3.8F, 4.5F));
        estudiantes.add(new Estudiante(12, "Sofia", "Torres", "Octavo", 4.9F, 3.6F, 4.1F));
        estudiantes.add(new Estudiante(13, "Milena", "Vargas", "noveno", 4.0F, 3.9F, 3.2F));
        estudiantes.add(new Estudiante(14, "Pepito", "Perez", "decimo", 3.0F, 2.4F, 1.9F));
    }

    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();
        for (Estudiante estudiante : this.estudiantes) {
            estudiante.calcularPromedio();
            estudiante.calcularAprobado();
            estudiantes.add(estudiante);
        }
        return estudiantes;
    }

    public Estudiante buscarEstudiantes(int codigo) {
        Estudiante estudiante = null;
        for (Estudiante e : estudiantes) {
            if (e.getCodigo() == codigo) {
                estudiante = e;
                estudiante.calcularPromedio();
                estudiante.calcularAprobado();
                break;
            }
        }
        return estudiante;
    }


    public void actualizarEstudiante(Estudiante estudianteActualizar) {
        Estudiante estudiante = buscarEstudiantes(estudianteActualizar.getCodigo());

        if (estudiante != null && estudiante.getPromedio() > 3) {
           /* estudiante.setNombre(estudianteActualizar.getNombre());
            estudiante.setApellido(estudianteActualizar.getApellido());
            estudiante.setCurso(estudianteActualizar.getCurso());*/
            estudiante.setNota1(estudianteActualizar.getNota1());
            estudiante.setNota2(estudianteActualizar.getNota2());
            estudiante.setNota3(estudianteActualizar.getNota3());
           /* estudiante.calcularPromedio();
            estudiante.calcularAprobado();*/
        }
    }



}
