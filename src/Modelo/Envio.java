/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ListaDoble.ListaDoble;
import Modelo.enums.Prioridad;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class Envio {
    private Long id_envio;
    private double precio;
    private Paquete paquete;
    private ListaDoble hist_entrega = new ListaDoble();
    private Prioridad prioridad;
    private String estado;
    /**
     * @return Long
     */
    public Long getId_envio() {
        return id_envio;
    }
    /**
     * @param id_envio
     */
    public void setId_envio(Long id_envio) {
        this.id_envio = id_envio;
    }
    /**
     * @return double
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    /**
     * @return Paquete
     */
    public Paquete getPaquete() {
        if (paquete == null) {
            paquete = new Paquete();
        }
        return paquete;
    }
    /**
     * @param paquete
     */
    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
    /**
     * @return ListaDoble
     */
    public ListaDoble getHist_entrega() {
        return hist_entrega;
    }
    /**
     * @param hist_entrega
     */
    public void setHist_entrega(ListaDoble hist_entrega) {
        this.hist_entrega = hist_entrega;
    }
    /**
     * @return Prioridad
     */
    public Prioridad getPrioridad() {
        return prioridad;
    }
    /**
     * @param prioridad
     */
    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }
    /**
     * @return String
     */
    public String getEstado() {
        return estado;
    }
    /**
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    /**
     * Cuando se lo llama de otra clase se lo va a reconocer a partir del id_envio
     */
    @Override
    public String toString() {
        return "" + id_envio;
    }
}
