package com.example.examen2;

public class ListaTrabajador {
    String nombre;
    String puesto;
    String departamento;

    public ListaTrabajador(String nombre, String puesto, String departamento){
        this.nombre = nombre;
        this.puesto = puesto;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String edad) {
        this.puesto = puesto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
