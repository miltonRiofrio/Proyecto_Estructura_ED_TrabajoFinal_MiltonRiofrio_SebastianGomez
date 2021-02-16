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
public class Persona {
    private Long id_persona;
    private String nombre;
    private String ci_ruc;
    private String telefono;
    private String ciudad;
    private String direccion;
    private Long id_rol;
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
    /**
     * @return String
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @return String
     */
    public String getCi_ruc() {
        return ci_ruc;
    }
    /**=
     * @param ci_ruc
     */
    public void setCi_ruc(String ci_ruc) {
        this.ci_ruc = ci_ruc;
    }
    /**
     * @return String
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * @return String
     */
    public String getCiudad() {
        return ciudad;
    }
    /**
     * @param ciudad
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    /**
     * @return String
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * @return
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
     *  Cuando se lo llama de otra clase se lo va a reconocer a partir del nombre
     */   
    @Override
    public String toString() {
        return nombre;
    }
}
