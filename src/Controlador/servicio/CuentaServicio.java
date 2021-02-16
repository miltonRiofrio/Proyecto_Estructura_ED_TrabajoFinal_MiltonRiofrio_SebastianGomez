/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.servicio;


import Controlador.Dao.CuentaDao;
import Modelo.Cuenta;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class CuentaServicio {
    private CuentaDao obj = new CuentaDao();
    /**
     * @return Cuenta
     */
    public Cuenta getCuenta() {
        return obj.getCuenta();
    }
    /**
     * Inicia Secion con el usuario y contraseña
     * @param usuario es el numero de cedula del empleado
     * @param clave es una clave unica de cada usuario
     * @return Cuenta
     */
    public Cuenta inicioSesion(String usuario, String clave) {
        return obj.inicioSesion(usuario, clave);
    }
}
