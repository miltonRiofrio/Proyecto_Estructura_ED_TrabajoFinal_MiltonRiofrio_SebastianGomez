/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.ListaDoble;

import Controlador.Utiles;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class ListaDoble {

    protected NodoDE cabecera;
    public static final int ORDENAR_ASCENDENTE = -1;
    public static final int ORDENAR_DESCENDENTE = 1;

    /**
     * Vuelve null a la ListaDoble
     */
    public ListaDoble() {
        this.cabecera = null;
    }

    /**
     * comprueba si la ListaDoble esta vacia
     *
     * @return Boolean
     */
    public boolean estaVacia() {
        return (this.cabecera == null);
    }

    /**
     * inserta informacion a la ListaDoble
     *
     * @param dato almacena toda la informacion a insertar (puede de ser
     * cualquier tipo)
     */
    public void insertar(Object dato) {

        if (estaVacia()) {
            NodoDE tmp = new NodoDE(dato, null, null);
            cabecera = tmp;
        } else {
            NodoDE tmp = new NodoDE(dato, null, null);
            NodoDE aux = cabecera;
            tmp.setSig(aux);
            aux.setAnt(tmp);
            cabecera = tmp;
        }
    }

    /**
     * Se da una vista de los datos guardados en la ListaDoble
     */
    public void verDato() {
        if (!estaVacia()) {
            NodoDE tmp = cabecera;
            while (tmp != null) {
                System.out.println(tmp.getDato().toString());
                if (tmp.getAnt() != null) {
                    System.out.println("--- " + tmp.getAnt().getDato().toString() + " ---");
                }
                tmp = tmp.getSig();
            }
        }
    }

    /**
     * Se da una vista del dato segun su posicion
     *
     * @param pos sirve para obtener el lugar de la ListaDoble que se quiera
     * observar
     * @return Object
     */
    public Object verDatoPos(int pos) {
        Object dato = null;
        if (!estaVacia() && pos >= 0) {
            NodoDE tmp = cabecera;
            for (int i = 0; i < pos; i++) {
                tmp = tmp.getSig();
                if (tmp == null) {
                    break; //termina el proceso del ciclo for
                }
            }
            dato = (tmp != null) ? tmp.getDato() : null;
        }
        return dato;
    }

    /**
     * Muestra la longitud de la lista
     *
     * @return int
     */
    public int tamano() {
        int tamano = 0;
        if (!estaVacia()) {
            NodoDE tmp = cabecera;
            while (tmp != null) {
                tamano++;
                tmp = tmp.getSig();
            }
        }
        return tamano;
    }

    /**
     * Se da una vista del dato segun su posicion
     *
     * @param pos sirve para obtener el lugar de la ListaDoble que se quiera
     * observar
     * @return Objects
     */
    public Object obtenerPorPosicion(int pos) {
        Object aux = null;
        if (estaVacia() || pos < 0) {
            System.out.println("Vacio");

        } else if (pos > tamano() - 1) {

            throw new ArrayIndexOutOfBoundsException("Fuera de Rango");
        } else if (pos == 0) {
            aux = verDatoPos(pos);
        } else {
            NodoDE iterador = cabecera;
            for (int i = 1; i < pos; i++) {
                if (iterador.getSig().getSig() == null) {
                    break;
                }
                iterador = iterador.getSig();
            }
            aux = iterador.getSig().getDato();
        }
        return aux;
    }

    /**
     * Se da una vista del dato segun su dato
     *
     * @param dato sirve para obtener el lugar de la ListaDoble que se quiera
     * observar
     * @return int
     */
    public int buscarPosPorDato(Object dato) {
        Object auxdato;
        int pos = 0;
        if (!estaVacia() && dato != null) {
            NodoDE iterador = cabecera;
            for (int i = 0; i < tamano(); i++) {
                if (iterador.getDato().toString().equals(dato)) {
                    auxdato = iterador.getDato();
                    pos = i;
                    System.out.println(auxdato + " en la posicion: " + pos);
                    break;
                } else if (!iterador.getDato().equals(dato) && i == tamano() - 1) {
                    throw new ArrayIndexOutOfBoundsException("Dato Erroreo");
                }
                System.out.println("Iterador: " + iterador.getDato());
                iterador = iterador.getSig();
            }
        } else {
            System.out.println("Vacio");
        }
        return pos;
    }

    /**
     * Permite modificar segun la posicion que se le asigne en la ListaDoble
     *
     * @param pos sirve para enviar la posicion del dato a modificar
     * @param dato es la nueva informacion que va a modificar un dato del la
     * ListaDoble
     */
    public void editarPorPos(int pos, Object dato) {
        if (pos >= 0 && pos < tamano()) {
            if (pos == 0) {
                cabecera.setDato(dato);
            } else {
                NodoDE aux = cabecera;
                for (int i = 0; i < pos; i++) {
                    aux = aux.getSig();
                }
                aux.setDato(dato);
            }
        } else {
            System.out.println("Fuera de rango");
        }
    }

    /**
     * Busca un elemento en la ListaDoble, partiendo por la mitad el tamaño de
     * la lista
     *
     * @param dato es el elemento que quiere buscar
     * @param atributo sirve como guia para buscar el dato deseado
     * @return Object
     */
    public Object busquedaBinaria(String dato, String atributo) {
        System.out.println("DATO " + dato + " ATRIBUTO " + atributo);
        int n = tamano();
        System.out.println("tamanio: " + tamano());
        int centro, inf = 0, sup = n - 1;
        while (inf <= sup) {
            centro = (sup + inf) / 2;

            System.out.println("centro " + centro + " ss " + obtenerPorPosicion(centro) + " saa " + dato);
            if (Utiles.comparar(dato, obtenerPorPosicion(centro), atributo)) {
                return obtenerPorPosicion(centro);
            } else if (Utiles.compareTo(dato, obtenerPorPosicion(centro), atributo) < 0) {
                sup = centro - 1;
                System.out.println(" sup " + sup);
            } else if (Utiles.compareTo(dato, obtenerPorPosicion(centro), atributo) == 0 && atributo.equals("id_rol")) {
                sup = centro - 1;
                System.out.println(" sup " + sup);
            } else {
                inf = centro + 1;
                System.out.println("inf " + inf);
            }
        }
        return null;
    }

    /**
     * Quita el dato por su posicion
     *
     * @param pos
     */
    public void eliminarPorPos(int pos) {
        if (!estaVacia()) {
            if (pos < 0) {
                System.out.println("Debe ser una posicion mayor a cero");
            } else {
                if (pos == 0) {
                    cabecera = cabecera.getSig();
                    cabecera.setAnt(null);
                } else if (pos <= (tamano() - 1)) {
                    NodoDE aux = cabecera;
                    for (int i = 0; i < pos - 1; i++) {
                        aux = aux.getSig();
                    }
                    NodoDE siguiente = aux.getSig();
                    aux.setSig(siguiente.getSig());
                    if (aux.getSig() != null) {
                        aux.getSig().setAnt(siguiente.getAnt());
                    }
                } else {
                    System.out.println("No se elimino");
                }
            }
        } else {
            System.out.println("Lista Vacia");
        }
    }

    /**
     * Ordena la Lista de forma ascendente o descendente
     *
     * @param tipo_ordenacion puede ser ascedente o descendente
     * @param atributo sirve como guia para ordenar la ListaDoble
     * @return ListaDoble
     */
    public ListaDoble ordenar(int tipo_ordenacion, String atributo) {
        if (!estaVacia()) {
            for (int i = 0; i < tamano() - 1; i++) {
                int k = i;
                for (int j = i + 1; j < tamano(); j++) {
                    if (Utiles.compareTo(obtenerPorPosicion(j), obtenerPorPosicion(k), atributo) == tipo_ordenacion) {
                        k = j;
                    }
                }
                Object aux = obtenerPorPosicion(i);
                editarPorPos(i, obtenerPorPosicion(k));
                editarPorPos(k, aux);
            }
        }
        return this;
    }
}
