/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.enums;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public enum Categoria {
    A("Tecnologia y electronica"),
    B("hogar"),
    C("moda"),
    D("implementos deportivos"),
    E("oficina y papeleria"),
    F("salud e higiene"),
    G("musica"),
    H("juguetes"),
    I("alimentacion"),
    J("para mascotas");
 
    private String Categoria;
    /**
     * @return String
     */
    public String getCategoria() {
        return Categoria;
    }
    /**
     * @param Categoria
     */
    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
    /**
     * @param Categoria
     */
    private Categoria(String Categoria) {
        this.Categoria = Categoria;
    }
    /**
     * Cuando se lo llama de otra clase se lo va a reconocer a partir de la Categoria
     */
    @Override
    public String toString() {
        return Categoria;
    }
}

