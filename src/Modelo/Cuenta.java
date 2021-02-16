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
public class Cuenta {

    private Long id_cuenta;
    private String usuario;
    private String contrasenia;
    private Long id_persona;
    /**
     * @return Long
     */   
    public Long getId_cuenta() {
        return id_cuenta;
    }
    /**
     * @param id_cuenta
     */   
    public void setId_cuenta(Long id_cuenta) {
        this.id_cuenta = id_cuenta;
    }
    /**
     * @return String
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * @return String
     */
    public String getContrasenia() {
        return contrasenia;
    }
    /**
     * @param contrasenia
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    /**
     * @return Long
     */
    public Long getId_persona() {
        return id_persona;
    }
    /**
     * @param id_persona
     */
    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }
}
