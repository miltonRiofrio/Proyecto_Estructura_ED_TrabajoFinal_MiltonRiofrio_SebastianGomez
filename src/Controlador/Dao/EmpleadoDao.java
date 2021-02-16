/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.Conexion;
import Modelo.Empleado;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class EmpleadoDao extends AdaptadorDao {

    private Empleado empleado;
    
    /**
     * Se superpone el nuevo Dao con su clase a la conexion que anteriormente tenia la clase AdapatadorDao 
     */
    public EmpleadoDao() {
        super(new Conexion(), Empleado.class);
    }
    
    /**
     * @return Empleado
     */
    public Empleado getEmpleado() {
        if (empleado == null) {
            empleado = new Empleado();
        }
        return empleado;
    }
    
    /**
     * @param empleado
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    /**
     * Metodo para guardar la informacion del atributo empleado al .json
     * @return Boolean
     */
    public Boolean guardar() {
        try {
            this.getEmpleado().setId_persona(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            this.getEmpleado().setId_person(this.getEmpleado().getId_persona());
            this.guardar(this.getEmpleado());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar empleado " + e);
            return false;
        }
    }
}