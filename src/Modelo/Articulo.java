/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.enums.Categoria;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class Articulo {
    private Long id_articulo;
    private String nombre_articulo;
    private int cantidad;
    private Categoria categoria;
    /**
     * @return Long
     */  
    public Long getId_articulo() {
        return id_articulo;
    }
    /**
     * @param id_articulo
     */
    public void setId_articulo(Long id_articulo) {
        this.id_articulo = id_articulo;
    }
    /**
     * @return String
     */
    public String getNombre_articulo() {
        return nombre_articulo;
    }
    /**
     * @param nombre_articulo
     */
    public void setNombre_articulo(String nombre_articulo) {
        this.nombre_articulo = nombre_articulo;
    }
    /**
     * @return int
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * @return Categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }
    /**
     * @param categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    /**
     * Cuando se lo llama de otra clase se lo va a reconocer a partir del id_articulo
     */
    @Override
    public String toString() {
        return "" + id_articulo;
    }       
}
