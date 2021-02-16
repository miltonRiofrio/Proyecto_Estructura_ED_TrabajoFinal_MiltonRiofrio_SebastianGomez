/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.servicio.EmpleadoServicio;
import Controlador.servicio.RolServicio;
import Modelo.Cuenta;
import Modelo.Empleado;
import Modelo.Rol;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class Sesion {
    private static Cuenta cuenta;
    private static Rol rol;
    private static Empleado empleado;

    /**
     * @return Empleado
     */
    public static Empleado getEmpleado() {
        return empleado;
    }
    /**
     * 
     * @param empleado
     */
    public static void setEmpleado(Empleado empleado) {
        Sesion.empleado = empleado;
    }
    /**
     * @return Cuenta
     */
    public static Cuenta getCuenta() {
        return cuenta;
    }
    /**
     * 
     * @param cuenta
     */
    public static void setCuenta(Cuenta cuenta) {
        Sesion.cuenta = cuenta;
    }
    /**
     * @return Rol
     */
    public static Rol getRol() {
        return rol;
    }
    /**
     * @param rol
     */
    public static void setRol(Rol rol) {
        Sesion.rol = rol;
    }
    /**
     * Metodo para conectar la carpeta datos al programa
     * XStream: Libreria para la serializacion y deserealizacion de objetos .JSON
     */ 
    public static void cargarDatos() {
        empleado = new EmpleadoServicio().buscar(cuenta.getId_cuenta().toString(), EmpleadoServicio.IDENTIFICADOR);
        rol = new RolServicio().buscar(empleado.getId_rol().toString(), RolServicio.IDENTIFICADOR);
    }
}
