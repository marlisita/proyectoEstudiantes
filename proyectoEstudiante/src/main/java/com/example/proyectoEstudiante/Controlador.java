package com.example.proyectoEstudiante;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
public class Controlador {
    private ServicioEstudiante servicio;

    public Controlador(ServicioEstudiante servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listarEstudiantes")
    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> estudiantes = servicio.listarEstudiantes();
        for (Estudiante estudiante : estudiantes) {
            estudiante.calcularPromedio();
            estudiante.calcularAprobado();
        }
        return estudiantes;
    }



    @GetMapping("/buscarEstudiantes/{codigo}")
    public ResponseEntity<Estudiante> buscarEstudiante(@PathVariable int codigo) {
        Estudiante estudiante = servicio.buscarEstudiantes(codigo);
        if (estudiante != null) {
            return new ResponseEntity<>(estudiante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/actualizarEstudiantes/{codigo}")
    public ResponseEntity<Void> actualizarEstudiante(@PathVariable int codigo, @RequestBody Estudiante estudianteActualizar) {
        servicio.actualizarEstudiante(estudianteActualizar);
        return ResponseEntity.noContent().build();
    }
}




