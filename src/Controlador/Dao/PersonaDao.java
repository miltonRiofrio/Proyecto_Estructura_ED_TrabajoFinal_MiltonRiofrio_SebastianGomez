/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.Conexion;
import Controlador.servicio.RolServicio;
import Modelo.Persona;
import Modelo.Rol;


/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class PersonaDao extends AdaptadorDao {
    private Persona persona;
    private RolDao rdao = new RolDao();
    /**
     * Se superpone el nuevo Dao con su clase a la conexion que anteriormente tenia la clase AdapatadorDao 
     */
    public PersonaDao() {
        super(new Conexion(), Persona.class);
    }
    /**
     * @return Persona
     */
    public Persona getPersona() {
        if(persona == null)
            persona = new Persona();
        return persona;
    }
    /**
     * Metodo para guardar la informacion del atributo persona al .json
     * @param persona guarda la informacion que se manda desde el EnvioDao
     * @return Boolean
     */
    public Boolean guardarPersona (Persona persona) {
        try {
            persona.setId_persona(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            Rol rol = new RolServicio().buscar("3", RolServicio.IDENTIFICADOR);
            persona.setId_rol(rol.getId_rol());
            this.guardar(persona);
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar persona "+ e);
            return false;
        }
    }
    /**
     * @param persona
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
