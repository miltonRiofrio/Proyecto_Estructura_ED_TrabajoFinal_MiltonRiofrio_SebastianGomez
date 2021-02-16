/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.Conexion;
import Controlador.ListaDoble.ListaDoble;
import Modelo.Articulo;

/**
 * @author Milton Riofrio, Sebastian Gomez
 */
public class ArticuloDao extends AdaptadorDao{
    private Articulo articulo;
    private ListaDoble ld = new ListaDoble();
    
    /**
     *Se superpone el nuevo Dao con su clase a la conexion que anteriormente tenia la clase AdapatadorDao 
     */
    public ArticuloDao() {
        super(new Conexion(), Articulo.class);
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
     * @return Articulo
     */
    public Articulo getArticulo() {
        if(articulo == null)
            articulo = new Articulo();
        return articulo;
    }
    
    /**
     * Metodo para guardar la informacion del atributo articulo al .json
     * @return Boolean
     */
    public Boolean guardar() {
        try {
            this.getArticulo().setId_articulo(Long.parseLong(String.valueOf(Long.parseLong("" + listar().verDatoPos(0)) + 1)));
            this.guardar(this.getArticulo());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar el articulo "+ e);
            return false;
        }
    }
    
    /**
     * Metodo para eliminar un parametro de la lista y del .json
     * @param pos se obtiene la posicion del dato que se va a borrar
     * @return Boolean
     */
    public Boolean eliminarArt(int pos) {
        try {
            this.eliminar(pos);
            return true;
        } catch (Exception e) {
            System.out.println("Error borrar el articulo "+ e);
            return false;
        }
    }
    
    /**
     * @param articulo
     */
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    
    /**
     * Metodo para obtener la informacion guardada en el atributo articulo y almacenarla en un aux
     * @return Articulo
     */
    private Articulo clonarArticulo() {
        Articulo aux = new Articulo();
        aux.setCantidad(articulo.getCantidad());
        aux.setCategoria(articulo.getCategoria());
        aux.setId_articulo(articulo.getId_articulo());
        aux.setNombre_articulo(articulo.getNombre_articulo());
        return aux;
    }
    
    /**
     * Metodo para insertar en la ListaDoble (ld) la informacion que ha sido almacenada en el metodo clonarArticulo
     * @return ListaDoble
     */
    public ListaDoble guardarArticulo() {
        try {
            ld.insertar(clonarArticulo());
            setArticulo(null);
            return ld;
        } catch (Exception e) {
            System.out.println("Error en guardar articulo" + e);
            return null;
        }
    }
}
