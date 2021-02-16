/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class Empleado extends Persona {
    private Long id_person;
    private int anios_trabajo;
    private double sueldo;
    private String licencia;
    /**
     * @return Long
     */
    public Long getId_person() {
        return id_person;
    }
    /**
     * @param id_person
     */
    public void setId_person(Long id_person) {
        this.id_person = id_person;
    }
    /**
     * @return int
     */   
    public int getAnios_trabajo() {
        return anios_trabajo;
    }
    /**=
     * @param anios_trabajo
     */
    public void setAnios_trabajo(int anios_trabajo) {
        this.anios_trabajo = anios_trabajo;
    }
    /**
     * @return double
     */
    public double getSueldo() {
        return sueldo;
    }
    /**
     * @param sueldo
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    /**
     * @return String
     */
    public String getLicencia() {
        return licencia;
    }
    /**
     * @param licencia
     */
    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }
}
