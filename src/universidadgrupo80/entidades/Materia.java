/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo80.entidades;

/**
 *
 * @author Usuario
 */
public class Materia {
    private int IdMateria; 
    private String nombre ;
    private int año;
    private boolean estado;

    public Materia() {
    }

    public Materia(String nombre, int año, boolean estado) {
        this.nombre = nombre;
        this.año = año;
        this.estado = estado;
    }

    public Materia(int IdMateria, String nombre, int año, boolean estado) {
        this.IdMateria = IdMateria;
        this.nombre = nombre;
        this.año = año;
        this.estado = estado;
    }

    public int getIdMateria() {
        return IdMateria;
    }

    public void setIdMateria(int IdMateria) {
        this.IdMateria = IdMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return IdMateria + ", " + nombre + ", " + año + ", ";
    }

   
}
