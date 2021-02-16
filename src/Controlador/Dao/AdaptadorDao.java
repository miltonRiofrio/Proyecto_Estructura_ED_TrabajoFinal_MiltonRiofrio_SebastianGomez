/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.Conexion;
import Controlador.ListaDoble.ListaDoble;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

/**
 * @author Milton Riofrio, Sebastian Gomez
 */
public class AdaptadorDao implements InterfazDao {
    //Dao: Objeto de Acceso a datos (.json)
    private Conexion conexion;
    private Class clazz;
    
    /**
     * @param conexion
     * @param clazz
     */
    public AdaptadorDao(Conexion conexion, Class clazz) {
        this.conexion = conexion;
        this.clazz = clazz;
    }
    
    /**
     * Sirve para guardar dentro de una ListaDoble todos las datos que estan guardados en el archivo .json que se haya seleccionado
     * @return ListaDoble
     */
    @Override
    public ListaDoble listar() {
        ListaDoble lista = new ListaDoble();
        try {
            lista = (ListaDoble) conexion.getXtrStream().fromXML(new FileReader(conexion.getREPO() + File.separatorChar + clazz.getSimpleName() + ".json"));
        } catch (Exception e) {
            System.out.println("No se pudo listar " + e);
            e.printStackTrace();
        }
        return lista;
    }
    
    /**
     * @param o Obtiene toda la informacion que se va a añadir en la ListaDoble y a su vez en el .json
     * @throws java.lang.Exception
     */
    @Override
    public void guardar(Object o) throws Exception {
        ListaDoble lista = listar();
        lista.insertar(o);
        conexion.getXtrStream().toXML(lista, new FileOutputStream(conexion.getREPO() + File.separatorChar + clazz.getSimpleName() + ".json"));
    }
    
    /**
     * @param pos Se obtiene la posicion del dato que quiere eliminar de la lista y del .json
     * @throws java.lang.Exception
     */
    @Override
    public void eliminar(Object pos) throws Exception {
        ListaDoble lista = listar();
        lista.eliminarPorPos((int)pos);
        conexion.getXtrStream().toXML(lista, new FileOutputStream(conexion.getREPO() + File.separatorChar + clazz.getSimpleName() + ".json"));
    }
    
    /**
     * @param o Nueva informacion que se va a sobreescribir en la posicion ya establecida en la lista y en el .json 
     * @param pos Se obtiene la posicion del dato que se quiere modificar en la lista y en el .json
     * @return Boolean
     * @throws java.lang.Exception
     */
    @Override
    public Boolean modificar(Object o, int pos) throws Exception {
        ListaDoble lista = listar();
        lista.editarPorPos(pos, o);
        conexion.getXtrStream().toXML(lista, new FileOutputStream(conexion.getREPO() + File.separatorChar + clazz.getSimpleName() + ".json"));
        return false;
    }
}
