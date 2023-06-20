package com.example.proyectoEstudiante;
import java.text.DecimalFormat;
public class Estudiante {
    private int codigo;
    private String nombre;
    private String apellido;
    private String curso;
    private float nota1;
    private float nota2;
    private float nota3;
    private String aprobado;
    private float promedio;


    public Estudiante(int codigo, String nombre, String apellido, String curso, float nota1, float nota2, float nota3) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.curso = curso;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        calcularAprobado();
        calcularPromedio();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
        calcularPromedio();
        calcularAprobado();
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
        calcularPromedio();
        calcularAprobado();
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
        calcularPromedio();
        calcularAprobado();
    }
    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public String getAprobado() {
        return aprobado;
    }

    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }
    public float calcularPromedio() {
        float suma = nota1 + nota2 + nota3;
        promedio = suma / 3;
        return promedio;
    }


    public String  calcularAprobado() {
        if (promedio >= 3.0 && promedio <= 5.0) {
            aprobado = "Aprobado";
        } else {
            aprobado = "Reprobado";
        }
        return aprobado;
    }


    @Override
    public String toString() {
        return "Estudiante" +
                "código:" + codigo +
                "\nnombre:" + nombre +
                "\napellido:" + apellido +
                "\ncurso:" + curso +
                "\nnota1:" + nota1 +
                "\nnota2:" + nota2 +
                "\nnota3:" + nota3 +
                "\naprobado:" + aprobado +
                "\npromedio:" + promedio +
                "\n\n";
    }
}
