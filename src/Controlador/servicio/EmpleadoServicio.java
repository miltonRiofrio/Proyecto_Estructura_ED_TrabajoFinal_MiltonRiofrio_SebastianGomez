/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.servicio;

import Controlador.Dao.EmpleadoDao;
import Controlador.ListaDoble.ListaDoble;
import Modelo.Empleado;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class EmpleadoServicio{
    
    public static String IDENTIFICADOR = "id_person";
    public static String ANIOS_TRABAJO = "anios_trabajo";
    public static String LICENCIA = "licencia";
    public static String SUELDO = "sueldo";
    
    private EmpleadoDao obj = new EmpleadoDao();
    
    /**
     * @return Empleado
     */
    public Empleado getEmpleado() {
        return obj.getEmpleado();
    }
    
    /**
     * @param empleado
     */
    public void fijarEmpleado(Empleado empleado) {
        obj.setEmpleado(empleado);
    }
    
    /**
     * Busca un empleado en la ListaDoble
     * @param dato sirve para que el metodo busquedaBinaria encuentre dicho elemento
     * @param atributo es el atributo de la clase Empleado que sirve como guia para la busqueda
     * @return Empleado
     */
    public Empleado buscar(String dato, String atributo) {
        ListaDoble empleados = obj.listar();
        if(empleados.tamano() > 0) {
            return (Empleado)empleados.busquedaBinaria(dato, atributo);
        } else
            return null;
    }
}
