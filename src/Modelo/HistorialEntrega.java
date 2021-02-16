/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class HistorialEntrega {
    private Long id_hist_entrega;
    private Envio envio;
    private Empleado camionero;
    private Camion camion;
    private Date fecha_entrega;
    private String ciudad_origen;
    private String ciudad_destino;
    /**
     * @return Long
     */
    public Long getId_hist_entrega() {
        return id_hist_entrega;
    }
    /**
     * @param id_hist_entrega
     */
    public void setId_hist_entrega(Long id_hist_entrega) {
        this.id_hist_entrega = id_hist_entrega;
    }
    /**
     * @return Envio
     */
    public Envio getEnvio() {
        return envio;
    }
    /**
     * @param envio
     */
    public void setEnvio(Envio envio) {
        this.envio = envio;
    }
    /**
     * @return Empleado
     */
    public Empleado getCamionero() {
        if (camionero == null) {
            camionero = new Empleado();
        }
        return camionero;
    }
    /**
     * @param camionero
     */
    public void setCamionero(Empleado camionero) {
        this.camionero = camionero;
    }
    /**
     * @return Camion
     */
    public Camion getCamion() {
        if (camion == null) {
            camion = new Camion();
        }
        return camion;
    }
    /**
     * @param camion
     */
    public void setCamion(Camion camion) {
        this.camion = camion;
    }
    /**
     * @return Date
     */
    public Date getFecha_entrega() {
        return fecha_entrega;
    }
    /**
     * @param fecha_entrega
     */
    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }
    /**
     * @return String
     */
    public String getCiudad_origen() {
        return ciudad_origen;
    }
    /**
     * @param ciudad_origen
     */
    public void setCiudad_origen(String ciudad_origen) {
        this.ciudad_origen = ciudad_origen;
    }
    /**
     * @return String
     */
    public String getCiudad_destino() {
        return ciudad_destino;
    }
    /**
     * @param ciudad_destino
     */
    public void setCiudad_destino(String ciudad_destino) {
        this.ciudad_destino = ciudad_destino;
    }  
    /**
     * Cuando se lo llama de otra clase se lo va a reconocer a partir del id_hist_entrega
     */
    @Override
    public String toString() {
        return "" + id_hist_entrega;
    }
}
