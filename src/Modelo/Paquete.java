/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.ListaDoble.ListaDoble;
import java.util.Date;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class Paquete {
    private Long id_paquete;
    private Persona destinatario;
    private Persona remitente;
    private double peso;
    private boolean fragil;
    private Date fecha_envio;
    private Date fecha_entrega;
    private ListaDoble contenido = new ListaDoble();
    /**
     * @return Long
     */
    public Long getId_paquete() {
        return id_paquete;
    }
    /**
     * @param id_paquete
     */
    public void setId_paquete(Long id_paquete) {
        this.id_paquete = id_paquete;
    }
    /**
     * @return Persona
     */
    public Persona getDestinatario() {
        if (destinatario == null) {
            destinatario = new Persona();
        }
        return destinatario;
    }
    /**
     * @param destinatario
     */
    public void setDestinatario(Persona destinatario) {
        this.destinatario = destinatario;
    }
    /**
     * @return Persona
     */
    public Persona getRemitente() {
        if (remitente == null) {
            remitente = new Persona();
        }
        return remitente;
    }
    /**
     * @param remitente
     */
    public void setRemitente(Persona remitente) {
        this.remitente = remitente;
    }
    /**
     * @return double
     */
    public double getPeso() {
        return peso;
    }
    /**
     * @param peso
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }
    /**
     * @return boolean
     */
    public boolean getFragil() {
        return fragil;
    }
    /**
     * @param fragil
     */
    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }
    /**
     * @return Date
     */
    public Date getFecha_envio() {
        return fecha_envio;
    }
    /**
     * @param fecha_envio
     */
    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
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
     * @return ListaDoble
     */
    public ListaDoble getContenido() {
        return contenido;
    }
    /**
     * @param contenido
     */
    public void setContenido(ListaDoble contenido) {
        this.contenido = contenido;
    }
}
