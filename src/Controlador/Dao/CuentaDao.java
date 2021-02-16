/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.Conexion;
import Controlador.ListaDoble.ListaDoble;
import Modelo.Cuenta;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class CuentaDao extends AdaptadorDao{
    
    private Cuenta cuenta;
    
    /**
     * *Se superpone el nuevo Dao con su clase a la conexion que anteriormente tenia la clase AdapatadorDao 
     */
    public CuentaDao() {
        super(new Conexion(), Cuenta.class);
    }
    
    /**
     * @return Cuenta
     */
    public Cuenta getCuenta() {
        if(cuenta == null)
            cuenta = new Cuenta();
        return cuenta;
    }
    
    /**
     * Metodo para guardar la informacion de la cuenta cuenta al .json
     * @return Boolean
     */
    public Boolean guardar() {
        try {
            this.getCuenta().setId_cuenta(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            this.guardar(this.getCuenta());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar Cuenta"+ e);
            return false;
        }
    }
    
    /**
     * @param cuenta
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    /**
     * Metodo que ordena la lista cuenta a partir del usuario de forma ascendente o descendente
     * @param cuentas
     * @param tipo_ordenacion
     * @param parametro
     * @return ListaDoble
     */
    public ListaDoble ordenar(ListaDoble cuentas, int tipo_ordenacion, String parametro) {
        cuentas.ordenar(tipo_ordenacion, parametro);
        return cuentas;
    }
    
    /**
     * Metodo que permite encontrar el usuario que se ha ingresado en el FrmRegistro
     * @param usuario es el atributo que almacena la informacion que se ha ingresado en el TextField de usuario en el FrmRegistro
     * @param clave es el atributo que almacena la informacion que se ha ingresado en el TextField de clave en el FrmRegistro
     * @return Cuenta
     */
    public Cuenta inicioSesion(String usuario, String clave) {
        ListaDoble cuentas = listar();
        cuentas = ordenar(cuentas, ListaDoble.ORDENAR_ASCENDENTE, "usuario");
        Cuenta cuenta = (Cuenta) cuentas.busquedaBinaria(usuario, "usuario");
        if(cuenta != null) {
            if(!cuenta.getContrasenia().equals(clave)) 
                cuenta = null;            
        }
        return cuenta;
    }   
}
