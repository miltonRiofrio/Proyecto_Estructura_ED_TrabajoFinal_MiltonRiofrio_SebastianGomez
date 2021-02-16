/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Tablas;

import Controlador.ListaDoble.ListaDoble;
import Modelo.Envio;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class ModeloTablaEnvios extends AbstractTableModel{
    private ListaDoble envios = new ListaDoble();
    /**
     * 
     * @return ListaDoble
     */
    public ListaDoble getEnvios() {
        return envios;
    }
    /**
     * @param envios
     */
    public void setEnvios(ListaDoble envios) {
        this.envios = envios;
    }
    /**
     * Obtiene el tamaño de la lista de los Envios
     */
    @Override
    public int getRowCount() {
        return envios.tamano();
    }
    /**
     * Se define en la tabla el numero de columnas
     */
    @Override
    public int getColumnCount() {
        return 12;
    }
    /**
     * Se muestra la informacion que comprende a los Envios en cada fila de la tabla 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Envio e = (Envio)envios.verDatoPos(rowIndex);
        switch (columnIndex) {
            case 0:
                return e.getId_envio();
            case 1:
                return e.getPaquete().getId_paquete();
            case 2:
                return e.getPaquete().getRemitente().getNombre();
            case 3:
                return e.getPaquete().getRemitente().getCi_ruc();
            case 4:
                return e.getPaquete().getFecha_envio();
            case 5:
                return e.getPaquete().getFecha_entrega();
            case 6:
                return e.getPrioridad();
            case 7:
                return e.getEstado();
            case 8:
                return e.getPaquete().getRemitente().getCiudad();
            case 9:
                return e.getPaquete().getDestinatario().getCiudad();
            case 10:
                return e.getPaquete().getFragil();
            case 11:
                return e.getPrecio();
            default:
                return null;
        }
    }
    /**
     * Se definen los nombre de las columnas de la tabla
     */
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id Envio";
            case 1:
                return "Id Paquete";
            case 2:
                return "Remitente";
            case 3:
                return "CI Cliente";
            case 4:
                return "Fecha de Envio";
            case 5:
                return "Fecha de Entrega";
            case 6:
                return "Prioridad";
            case 7:
                return "Estado de Envio";
            case 8:
                return "Origen";
            case 9:
                return "Destino";
            case 10:
                return "Es Fragil";
            case 11:
                return "Precio";
            default:
                return null;
        }
    }
}
