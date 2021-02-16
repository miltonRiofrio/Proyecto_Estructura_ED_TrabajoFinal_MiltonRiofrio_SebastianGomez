/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Tablas;

import Controlador.ListaDoble.ListaDoble;
import Modelo.HistorialEntrega;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class ModeloTablaCamionero  extends AbstractTableModel {
    private ListaDoble camionero = new ListaDoble();
    /**
     * 
     * @return ListaDoble
     */
    public ListaDoble getCamionero() {
        return camionero;
    }
    /**
     * @param camionero
     */
    public void setCamionero(ListaDoble camionero) {
        this.camionero = camionero;
    }
    /**
     * Obtiene el tamaño de la lista de los Camioneros
     */
    @Override
    public int getRowCount() {
        return camionero.tamano();
    }
    /**
     * Se define en la tabla el numero de columnas
     */
    @Override
    public int getColumnCount() {
        return 10;
    }
    /**
     * Se muestra la informacion que comprende a los Camioneros en cada fila de la tabla 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HistorialEntrega he = (HistorialEntrega)camionero.verDatoPos(rowIndex);
        switch (columnIndex) {
            case 0:
                return he.getCamionero().getNombre();
            case 1:
                return he.getCamion().getPlaca();
            case 2:
                return he.getId_hist_entrega();
            case 3:
                return he.getCamionero().getCi_ruc();
            case 4:
                return he.getCamionero().getLicencia();
            case 5:
                return he.getCamionero().getSueldo();
            case 6:
                return he.getCamionero().getAnios_trabajo();
            case 7:
                return he.getCamionero().getCiudad();
            case 8:
                return he.getCamionero().getDireccion();
            case 9:
                return he.getCamionero().getTelefono();
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
                return "Nombre Conductor";
            case 1:
                return "Placa";
            case 2:
                return "IdHEntrega";
            case 3:
                return "Cedula";
            case 4:
                return "Licencia";
            case 5:
                return "Sueldo";
            case 6:
                return "Años de Trabajo";
            case 7:
                return "Ciudad";
            case 8:
                return "Direccion";
            case 9:
                return "Telefono";
            default:
                return null;
        }
    }
}
