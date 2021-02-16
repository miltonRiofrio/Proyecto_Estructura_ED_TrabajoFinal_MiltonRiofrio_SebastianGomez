/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.enums.Capacidad;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class Camion {
    private String placa;
    private String modelo;
    private Capacidad capacidad;
    /**
     * @return String
     */    
    public String getPlaca() {
        return placa;
    }
    /**
     * @param placa
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    /**
     * @return String
     */
    public String getModelo() {
        return modelo;
    }
    /**
     * @param Modelo
     */
    public void setModelo(String Modelo) {
        this.modelo = Modelo;
    }
    /**
     * @return Capacidad
     */
    public Capacidad getCapacidad() {
        return capacidad;
    }
    /**
     * @param capacidad
     */
    public void setCapacidad(Capacidad capacidad) {
        this.capacidad = capacidad;
    }
}
