/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.enums.Capacidad;
import Modelo.enums.Categoria;
import Modelo.enums.Prioridad;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.swing.JComboBox;


/**
 * @author Milton Riofrio, Sebastian Gomez
 */
public class Utiles {
    /**
     * 
     * @param o dato que se va a comparar
     * @param o1 posicion del centro de la lista en donde se encuentra el dato
     * @param atributoClase atributo (id) que va servir de guia para encontrar el dato
     * @return int
     */
    public static int compareTo(Object o, Object o1, String atributoClase) {
        int i = 0;
        if (o instanceof Integer && o1 instanceof Integer) {
            Integer uno = (Integer) o;
            Integer dos = (Integer) o1;
            if (uno > dos) {
                i = 1;
            } else if (uno < dos) {
                i = -1;
            }

        } else {
            String uno = extracciondato(o, atributoClase);
            String dos = extracciondato(o1, atributoClase);
            if (uno != null && dos != null) {
                if (uno.toUpperCase().compareTo(dos.toUpperCase()) > 0) {
                    i = 1;
                } else {
                    i = -1;
                }
            } 
        }
        return i;
    }
    
    /**
     * @param obj posicion del centro de la lista en donde se encuentra el dato
     * @param atributoClase atributo (id) que va servir de guia para encontrar el dato
     * @return String
     */
    private static String extracciondato(Object obj, String atributoClase) {
        Class clase = obj.getClass();
        Field atributo = null;
        Object informacion = null;
        for (Field f : clase.getDeclaredFields()) {
            if (f.getName().toString().equalsIgnoreCase(atributoClase)) {
                atributo = f;
            }
        }
        if (atributo != null) {
            //  Method metodo = null;
            for (Method metodoAux : clase.getMethods()) {
                if (metodoAux.getName().startsWith("get")) {
                    if (metodoAux.getName().toLowerCase().endsWith(atributo.getName())) {
                        try {
                            informacion = metodoAux.invoke(obj);
                            break;
                        } catch (Exception e) {
                            System.out.println("Error de metodo " + e);
                        }
                    }
                }
            }
        }
        return (informacion != null) ? informacion.toString() : null;
    }
    /**
     * 
     * @param uno dato que se va a comparar
     * @param obj posicion del centro de la lista en donde se encuentra el dato
     * @param atributoClase atributo (id) que va servir de guia para encontrar el dato
     * @return Boolean
     */
    public static Boolean comparar(String uno, Object obj, String atributoClase) {
        String dos = extracciondato(obj, atributoClase);
        return (dos != null) ? uno.equals(dos.toString()) : false;
    }
    ////////////////////////////////////////////////////////////////////////////
    /**
     * Metodo que carga los atributos de la Clase Categoria a un combobox
     * @param cbx
     */
    public static void cargarComboCategorias(JComboBox cbx) {
        cbx.removeAllItems();
        for (int i = 0; i < Utiles.obtenerCategorias().length; i++) {
            cbx.addItem(Utiles.obtenerCategorias()[i]);
        }
    }
    
    /**
     * Se obtienen de la clase Categoria el atriburo que se ha seleccionado en el combobox 
     * @param cbx
     * @return Categoria
     */
    public static Categoria obtenerCategorias(JComboBox cbx) {
        return (Categoria) cbx.getSelectedItem();
    }
    
    /**
     * Metodo que llama a los valores obtenidos mediante la Clase Categoria
     * @return Categoria[]
     */
    public static Categoria[] obtenerCategorias() {
        return Categoria.values();
    }
    ////////////////////////////////////////////////////////////////////////////
    /**
     * Metodo que carga los atributos de la Clase Capacidad a un combobox
     * @param cbx
     */
    public static void cargarComboCapacidades(JComboBox cbx) {
        cbx.removeAllItems();
        for (int i = 0; i < Utiles.obtenerCapacidades().length; i++) {
            cbx.addItem(Utiles.obtenerCapacidades()[i]);
        }
    }
    
    /**
     * Se obtienen de la clase Capacidad el atriburo que se ha seleccionado en el combobox 
     * @param cbx
     * @return Capacidad
     */
    public static Capacidad obtenerCapacidades(JComboBox cbx) {
        return (Capacidad) cbx.getSelectedItem();
    }
    
    /**
     * Metodo que llama a los valores obtenidos mediante la Clase Capacidad
     * @return Capacidad[]
     */
    public static Capacidad[] obtenerCapacidades() {
        return Capacidad.values();
    }
    ////////////////////////////////////////////////////////////////////////////
    /**
     * Metodo que carga los atributos de la Clase Prioridad a un combobox
     * @param cbx
     */
    public static void cargarComboPrioridades(JComboBox cbx) {
        cbx.removeAllItems();
        for (int i = 0; i < Utiles.obtenerPrioridades().length; i++) {
            cbx.addItem(Utiles.obtenerPrioridades()[i]);
        }
    }
    
    /**
     * Se obtienen de la clase Prioridad el atriburo que se ha seleccionado en el combobox
     * @param cbx
     * @return Prioridad
     */
    public static Prioridad obtenerPrioridades(JComboBox cbx) {
        return (Prioridad) cbx.getSelectedItem();
    }
    
    /**
     * Metodo que llama a los valores obtenidos mediante la Clase Prioridad
     * @return Prioridad[]
     */
    public static Prioridad[] obtenerPrioridades() {
        return Prioridad.values();
    }
}
