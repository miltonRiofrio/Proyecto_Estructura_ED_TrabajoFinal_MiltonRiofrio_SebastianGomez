/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.Conexion;
import Controlador.ListaDoble.ListaDoble;
import Modelo.HistorialEntrega;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class HistorialEntregaDao extends AdaptadorDao{
    private HistorialEntrega historialEntrega;
    private ListaDoble ld = new ListaDoble();
    private EmpleadoDao condDao = new EmpleadoDao();
    /**
     * Se superpone el nuevo Dao con su clase a la conexion que anteriormente tenia la clase AdapatadorDao 
     */
    public HistorialEntregaDao() {
        super(new Conexion(), HistorialEntrega.class);
    }
    /**
     * @return ListaDoble
     */
    public ListaDoble getLd() {
        return ld;
    }
    /**
     * @param ld
     */
    public void setLd(ListaDoble ld) {
        this.ld = ld;
    }
    /**
     * @return HistorialEntrega
     */
    public HistorialEntrega getHistorialEntrega() {
        if(historialEntrega == null)
            historialEntrega = new HistorialEntrega();
        return historialEntrega;
    }
    /**
     * Metodo para guardar la informacion del atributo historialEntrega al .json
     * @return Boolean
     */
    public Boolean guardar() {
        try {
            this.getHistorialEntrega().setId_hist_entrega(Long.parseLong(String.valueOf(Long.parseLong("" + listar().verDatoPos(0)) + 1)));
            condDao.guardar(this.getHistorialEntrega().getCamionero());
            this.guardar(this.getHistorialEntrega());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar historial entrega "+ e);
            return false;
        }
    }
    /**
     * Metodo para eliminar un parametro de la lista y del .json
     * @param pos se obtiene la posicion del dato que se va a borrar
     * @return Boolean
     */
    public Boolean eliminarHE(int pos) {
        try {
            this.eliminar(pos);
            return true;
        } catch (Exception e) {
            System.out.println("Error borrar el articulo "+ e);
            return false;
        }
    }
    /**
     * @param historialEntrega
     */
    public void setHistorialEntrega(HistorialEntrega historialEntrega) {
        this.historialEntrega = historialEntrega;
    }
    /**
     * Metodo para obtener la informacion guardada en el atributo historialEntrega y almacenarla en un aux
     * @return HistorialEntrega
     */
    private HistorialEntrega clonarHE() {
        HistorialEntrega aux = new HistorialEntrega();
        aux.setCamion(historialEntrega.getCamion());
        aux.setCamionero(historialEntrega.getCamionero());
        aux.setCiudad_destino(historialEntrega.getCiudad_destino());
        aux.setCiudad_origen(historialEntrega.getCiudad_origen());
        aux.setEnvio(historialEntrega.getEnvio());
        aux.setFecha_entrega(historialEntrega.getFecha_entrega());
        aux.setId_hist_entrega(historialEntrega.getId_hist_entrega());
        return aux;
    }
    /**
     * Metodo para insertar en la ListaDoble (ld) la informacion que ha sido almacenada en el metodo clonarHE
     * @return ListaDoble
     */
    public ListaDoble guardarHE() {
        try {
            ld.insertar(clonarHE());
            setHistorialEntrega(null);
            return ld;
        } catch (Exception e) {
            System.out.println("Error en guardar historial entrega" + e);
            return null;
        }
    }
}
