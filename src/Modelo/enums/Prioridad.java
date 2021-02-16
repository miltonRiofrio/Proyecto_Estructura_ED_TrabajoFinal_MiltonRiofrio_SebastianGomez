/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.enums;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public enum Prioridad {
    ALTA("Alta"),
    MEDIA("Media"),
    BAJA("Baja");
    
    private String Prioridad;
    /**
     * @return String
     */
    public String getPrioridad() {
        return Prioridad;
    }
    /**
     * @param Prioridad
     */
    public void setPrioridad(String Prioridad) {
        this.Prioridad = Prioridad;
    }
    /**
     * @param Prioridad
     */
    private Prioridad(String Prioridad){
        this.Prioridad = Prioridad;
    }
    /**
     * Cuando se lo llama de otra clase se lo va a reconocer a partir de la Prioridad
     */
    @Override
    public String toString() {
        return Prioridad;
    }
}
