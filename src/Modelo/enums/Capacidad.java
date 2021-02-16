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
public enum Capacidad {
    LIVIANA("Liviana"),
    MEDIA("Media"),
    PESADA("Pesada");
    
    private String Capacidad;
    /**
     * @return String
     */
    public String getCapacidad() {
        return Capacidad;
    }
    /**
     * @param Capacidad
     */
    public void setCapacidad(String Capacidad) {
        this.Capacidad = Capacidad;
    }
    /**
     * @param Capacidad
     */  
    private Capacidad (String Capacidad){
        this.Capacidad = Capacidad;
    }
    /**
     * Cuando se lo llama de otra clase se lo va a reconocer a partir de la Capacidad
     */
    @Override
    public String toString() {
        return Capacidad; //To change body of generated methods, choose Tools | Templates.
    }
  
}
