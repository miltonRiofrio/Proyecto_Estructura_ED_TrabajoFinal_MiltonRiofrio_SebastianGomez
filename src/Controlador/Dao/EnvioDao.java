/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.Conexion;
import Modelo.Envio;
import Vistas.RegistroEnvios;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class EnvioDao extends AdaptadorDao{
    private Envio envio;
    private PersonaDao pdao = new PersonaDao();

    /**
     * Se superpone el nuevo Dao con su clase a la conexion que anteriormente tenia la clase AdapatadorDao 
     */    
    public EnvioDao() {
        super(new Conexion(), Envio.class);
    }
    /**
     * @return Envio
     */
    public Envio getEnvio() {
        if(envio == null)
            envio = new Envio();
        return envio;
    }
    /**
     * Metodo para guardar la informacion del atributo envio al .json
     * @return Boolean
     */    
    public Boolean guardar() {
        try {
            this.getEnvio().setId_envio(Long.parseLong(String.valueOf(Long.parseLong("" + listar().verDatoPos(0)) + 1)));
            this.getEnvio().getPaquete().setId_paquete(Long.parseLong(String.valueOf(Long.parseLong("" + listar().verDatoPos(0)) + 1)));
            pdao.guardarPersona(this.getEnvio().getPaquete().getDestinatario());
            pdao.guardarPersona(this.getEnvio().getPaquete().getRemitente());
            this.guardar(this.getEnvio());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar envio "+ e);
            return false;
        }
    }
    /**
     * Modifica la informacion del envio buscandolo por el id_envio
     * @return Boolean
     */
    public Boolean modificarEnvio() {
        try {
            this.modificar(this.getEnvio(), this.listar().buscarPosPorDato(RegistroEnvios.getEdaoSeleccionado().getEnvio().toString()));
            return true;
        } catch (Exception e) {
            System.out.println("Error en modificar envio "+ e);
            return false;
        }
    }
    /**
     * Metodo para eliminar un parametro de la lista y del .json
     * @param pos se obtiene la posicion del dato que se va a borrar
     * @return Boolean
     */
    public Boolean eliminarEnvio(int pos) {
        try {
            this.eliminar(pos);
            return true;
        } catch (Exception e) {
            System.out.println("Error borrar el articulo "+ e);
            return false;
        }
    }
    /**
     * @param envio
     */
    public void setEnvio(Envio envio) {
        this.envio = envio;
    }
}
