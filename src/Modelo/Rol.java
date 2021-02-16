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
public class Rol {
    private Long id_rol;
    private String rol;
    /**
     * @return Long
     */
    public Long getId_rol() {
        return id_rol;
    }
    /**
     * @param id_rol
     */
    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }
    /**
     * @return String
     */
    public String getRol() {
        return rol;
    }
    /**
     * @param rol
     */
    public void setRol(String rol) {
        this.rol = rol;
    }  
    /**
     * Cuando se lo llama de otra clase se lo va a reconocer a partir del rol
     */
    @Override
    public String toString() {
        return rol;
    }
}
