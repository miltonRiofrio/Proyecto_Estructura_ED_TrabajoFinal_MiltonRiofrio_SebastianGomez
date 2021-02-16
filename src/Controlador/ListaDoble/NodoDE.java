/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ListaDoble;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class NodoDE {
    private NodoDE ant;
    private Object dato;
    private NodoDE sig;
    /**
     * Vuelve null a los nodos ant, sig y al dato
     */
    public NodoDE() {
        ant = null;
        dato = null;
        sig = null;
    }
    /**
     * guarda informacion nueva dentro de los atributos de la clase NodoDE
     * @param dato
     * @param sig
     * @param ant
     */
    public NodoDE(Object dato, NodoDE sig, NodoDE ant) {
        this.dato = dato;
        this.sig = sig;
        this.ant = ant;
    }
    /**
     * @return NodoDE
     */
    public NodoDE getAnt() {
        return ant;
    }
    /**
     * @param ant
     */
    public void setAnt(NodoDE ant) {
        this.ant = ant;
    }
    /**
     * @return Object
     */
    public Object getDato() {
        return dato;
    }
    /**
     * @param dato
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }
    /**
     * @return NodoDE
     */
    public NodoDE getSig() {
        return sig;
    }
    /**
     * @param sig
     */
    public void setSig(NodoDE sig) {
        this.sig = sig;
    }
}
