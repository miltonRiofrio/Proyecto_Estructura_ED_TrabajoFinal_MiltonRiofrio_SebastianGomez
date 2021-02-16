/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Dao.EnvioDao;
import Controlador.Dao.HistorialEntregaDao;
import Controlador.ListaDoble.ListaDoble;
import Controlador.Utiles;
import Vistas.Tablas.ModeloTablaHistorialEntrega;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class FrmHistorialEntrega extends javax.swing.JDialog {

    /**
     * Creates new form FrmHistorialEntrega
     */
    private ModeloTablaHistorialEntrega modeloHE = new ModeloTablaHistorialEntrega();
    private HistorialEntregaDao hed = new HistorialEntregaDao();
    private EnvioDao ed = new EnvioDao();
    private static ListaDoble histEntrega = new ListaDoble();
    /**
     * Vista que se ejecuta al llamarla
     * @param parent sirve para inicializarlo desde otra vista
     * @param modal su ejecucion no terminara hasta que se haya realizado todas las acciones requeridas en esta ventana
     */
    public FrmHistorialEntrega(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ed = RegistroEnvios.getEdaoSeleccionado();
        histEntrega = ed.getEnvio().getHist_entrega();
        hed.setLd(histEntrega);
        cargarTablaHE();
        limpiar();
    }
    /**
     * @return ListaDoble
     */
    public static ListaDoble getHistEntrega() {
        if (histEntrega == null) {
            histEntrega = new ListaDoble();
        }
        return histEntrega;
    }
    /**
     * @param histEntrega
     */
    public static void setHistEntrega(ListaDoble histEntrega) {
        FrmHistorialEntrega.histEntrega = histEntrega;
    }
    /**
     * Carga la informacion almacenada en la listaDoble de los historiales_entrega (histEntrega) para que se visualice en la tabla
     */
    private void cargarTablaHE() {
        modeloHE.setEntrega(getHistEntrega());
        tblcamionero.setModel(modeloHE);
        tblcamionero.updateUI();
    }
    /**
     * Limpia todas las casillas, carga la tabla y deja HistorialEntrega en nulo
     */
    private void limpiar() {
        txtCiudDest.setText("");
        txtFechEntreg.setText("");
        txtanioTrabajoCond.setText("");
        txtcedulaCond.setText("");
        txtciudCond.setText("");
        txtciudOrig.setText("");
        txtdirCond.setText("");
        lbllicenCond.setText("");
        txtmarcaCam.setText("");
        txtnomCond.setText("");
        txtsueldoCond.setText("");
        txtplacaCam.setText("");
        txttelfCond.setText("");
        hed.setHistorialEntrega(null);
        Utiles.cargarComboCapacidades(cbxcapacidad);
        cargarTablaHE();
    }
    /**
     * Almacena en el HistorialEntregaDao todo lo escrito en las casillas y se procede a guardar en el .json
     */
    private void guardarHE() {
        try {
            hed.getHistorialEntrega().getCamion().setCapacidad(Utiles.obtenerCapacidades(cbxcapacidad));
            hed.getHistorialEntrega().getCamion().setModelo(txtmarcaCam.getText());
            hed.getHistorialEntrega().getCamion().setPlaca(txtplacaCam.getText());

            hed.getHistorialEntrega().getCamionero().setAnios_trabajo(Integer.parseInt(txtanioTrabajoCond.getText()));
            hed.getHistorialEntrega().getCamionero().setCi_ruc(txtcedulaCond.getText());
            hed.getHistorialEntrega().getCamionero().setCiudad(txtciudCond.getText());
            hed.getHistorialEntrega().getCamionero().setDireccion(txtdirCond.getText());
            hed.getHistorialEntrega().getCamionero().setLicencia(lbllicenCond.getText());
            hed.getHistorialEntrega().getCamionero().setNombre(txtnomCond.getText());
            hed.getHistorialEntrega().getCamionero().setSueldo(Double.parseDouble(txtsueldoCond.getText()));
            hed.getHistorialEntrega().getCamionero().setTelefono(txttelfCond.getText());

            hed.getHistorialEntrega().setCiudad_destino(txtCiudDest.getText());
            hed.getHistorialEntrega().setCiudad_origen(txtciudOrig.getText());
            //*******cambiar el formato txtfechaentrega de String a Date
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String fechaEntreg = df.format(Date.valueOf(txtFechEntreg.getText()));
            hed.getHistorialEntrega().setFecha_entrega(Date.valueOf(fechaEntreg));
            hed.getHistorialEntrega().setCamion(hed.getHistorialEntrega().getCamion());
            hed.getHistorialEntrega().setCamionero(hed.getHistorialEntrega().getCamionero());
            hed.getHistorialEntrega().setEnvio(RegistroEnvios.getEdaoSeleccionado().getEnvio());
            if (hed.getHistorialEntrega().getFecha_entrega().after(hed.getHistorialEntrega().getEnvio().getPaquete().getFecha_envio())) {
                if (hed.getHistorialEntrega().getCamionero().getAnios_trabajo() >= 0 && hed.getHistorialEntrega().getCamionero().getAnios_trabajo() <= 57) {
                    if (hed.getHistorialEntrega().getCamionero().getSueldo() >= 400 && hed.getHistorialEntrega().getCamionero().getSueldo() <= 1000) {
                        if (hed.guardar()) {
                            JOptionPane.showMessageDialog(null, "Se ha guardado camionero");
                            setHistEntrega(hed.guardarHE());
                            limpiar();
                        } else {
                            JOptionPane.showMessageDialog(null, "No se ha guardado camionero");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Sueldo no permitido");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Año fuera de rango");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fecha de Emtrega debe ser mayor a la Fecha de Envio");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos erroneos: " + e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtnomCond = new javax.swing.JTextField();
        txtsueldoCond = new javax.swing.JTextField();
        txtcedulaCond = new javax.swing.JTextField();
        txttelfCond = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtanioTrabajoCond = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtdirCond = new javax.swing.JTextField();
        txtciudCond = new javax.swing.JTextField();
        lbllicenCond = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtplacaCam = new javax.swing.JTextField();
        txtmarcaCam = new javax.swing.JTextField();
        cbxcapacidad = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtciudOrig = new javax.swing.JTextField();
        txtCiudDest = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtFechEntreg = new javax.swing.JTextField();
        btneliminar = new javax.swing.JButton();
        btnGuardarenEnvios = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcamionero = new javax.swing.JTable();
        btnagregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setText("H I S T O R I A L  E N T R E G A");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(320, 20, 190, 14);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Conductor"));
        jPanel2.setLayout(null);

        jLabel2.setText("Nombre Conductor:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 30, 120, 14);

        jLabel3.setText("Sueldo:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 70, 80, 14);

        jLabel4.setText("Cedula:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(400, 30, 50, 14);

        jLabel8.setText("Telefono:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(400, 70, 60, 14);
        jPanel2.add(txtnomCond);
        txtnomCond.setBounds(160, 30, 130, 20);
        jPanel2.add(txtsueldoCond);
        txtsueldoCond.setBounds(160, 70, 130, 20);

        txtcedulaCond.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcedulaCondKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcedulaCondKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaCondKeyTyped(evt);
            }
        });
        jPanel2.add(txtcedulaCond);
        txtcedulaCond.setBounds(480, 30, 160, 20);
        jPanel2.add(txttelfCond);
        txttelfCond.setBounds(480, 70, 160, 20);

        jLabel10.setText("Anios Trabajo:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(30, 110, 90, 14);
        jPanel2.add(txtanioTrabajoCond);
        txtanioTrabajoCond.setBounds(160, 110, 130, 20);

        jLabel11.setText("Nro. Licencia:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(400, 150, 70, 14);

        jLabel12.setText("Direccion:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(30, 150, 70, 14);

        jLabel13.setText("Ciudad:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(400, 110, 41, 14);
        jPanel2.add(txtdirCond);
        txtdirCond.setBounds(160, 150, 130, 20);
        jPanel2.add(txtciudCond);
        txtciudCond.setBounds(480, 110, 160, 20);
        jPanel2.add(lbllicenCond);
        lbllicenCond.setBounds(480, 150, 160, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 30, 760, 190);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Camion"));
        jPanel3.setLayout(null);

        jLabel5.setText("Placa:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(80, 30, 76, 14);

        jLabel6.setText("Marca:");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(80, 70, 37, 14);

        jLabel7.setText("Capacidad:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(400, 40, 70, 14);
        jPanel3.add(txtplacaCam);
        txtplacaCam.setBounds(150, 30, 150, 20);
        jPanel3.add(txtmarcaCam);
        txtmarcaCam.setBounds(150, 70, 150, 20);

        jPanel3.add(cbxcapacidad);
        cbxcapacidad.setBounds(510, 40, 120, 20);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 220, 760, 100);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Ruta"));
        jPanel4.setLayout(null);

        jLabel14.setText("Ciudad Origen:");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(40, 30, 90, 14);

        jLabel15.setText("Ciudad destino:");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(390, 30, 90, 14);
        jPanel4.add(txtciudOrig);
        txtciudOrig.setBounds(140, 30, 140, 20);
        jPanel4.add(txtCiudDest);
        txtCiudDest.setBounds(520, 30, 140, 20);

        jLabel16.setText("Fecha de entrega:");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(230, 80, 100, 14);
        jPanel4.add(txtFechEntreg);
        txtFechEntreg.setBounds(370, 80, 140, 20);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 330, 760, 110);

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btneliminar);
        btneliminar.setBounds(310, 450, 75, 23);

        btnGuardarenEnvios.setText("Guardar en el Envio");
        btnGuardarenEnvios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarenEnviosActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarenEnvios);
        btnGuardarenEnvios.setBounds(580, 450, 130, 23);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Camionero"));

        tblcamionero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre Conductor", "Placa", "IdHEntrega", "Cedula", "Licencia", "Sueldo", "Anios de trabajo", "Ciudad", "Direccion", "Telefono"
            }
        ));
        jScrollPane1.setViewportView(tblcamionero);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(10, 480, 760, 160);

        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnagregar);
        btnagregar.setBounds(110, 450, 75, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Elimina entregas previamente seleccionadas de la lista y del .json
     * @param evt
     */
    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (tblcamionero.getSelectedRow() >= 0) {
            if (histEntrega.tamano() > 1) {
                histEntrega.eliminarPorPos(tblcamionero.getSelectedRow());
            } else {
                setHistEntrega(new ListaDoble());
                hed.setLd(new ListaDoble());
            }

            if (hed.eliminarHE(tblcamionero.getSelectedRow())) {
                JOptionPane.showMessageDialog(null, "Se ha borrado Camionero");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha borrado Camionero");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una celda");
        }

    }//GEN-LAST:event_btneliminarActionPerformed
    /***
     * Guarda el Historial Entrega en un Envio seleccionado
     * @param evt
     */
    private void btnGuardarenEnviosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarenEnviosActionPerformed
        // TODO add your handling code here:
        ed.getEnvio().setHist_entrega(histEntrega);

        if (ed.modificarEnvio()) {
            JOptionPane.showMessageDialog(null, "Se ha guardado el Historial de Entrega en el envio");
        } else {
            JOptionPane.showMessageDialog(null, "No se ha guardado el Historial de Entrega en el envio");
        }
        setHistEntrega(new ListaDoble());
        this.setVisible(false);
        new RegistroEnvios().setVisible(true);
    }
    /**
     * 
     * @param evt
     */
    private void btnagregar1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarenEnviosActionPerformed
    /**
     * Comprueba si las casillas estan llenas y cumplen con el tipo de dato asignado a cada atributo de la clase HistorialEntrega
     * @param evt
     */
    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
        if (txtcedulaCond.getText().matches("^[0-9]{10}$")) {
            if (txttelfCond.getText().matches("^09[0-9]{8}$")) {
                if (txtplacaCam.getText().matches("^[A-Z]{3}-[0-9]{4}$")) {
                    if (!txtCiudDest.getText().equals("") && !txtciudCond.getText().equals("") && !txtciudOrig.getText().equals("") && !txtdirCond.getText().equals("") && !lbllicenCond.getText().equals("") && !txtmarcaCam.getText().equals("") && !txtnomCond.getText().equals("") && !txtplacaCam.getText().equals("")) {
                        guardarHE();
                    } else {
                        JOptionPane.showMessageDialog(null, "Faltan Datos");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Placa Incorrecta");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Telefono Incompleto o fuera de rango");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cedula Incompleta o fuera de rango");
        }
    }//GEN-LAST:event_btnagregarActionPerformed
    /**
     * 
     * @param evt
     */
    private void txtcedulaCondKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaCondKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtcedulaCondKeyTyped
    /**
     * 
     * @param evt
     */
    private void txtcedulaCondKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaCondKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtcedulaCondKeyPressed
    /**
     * Repite en el lbllicenCond la informacion que se encuentra en txtcedulaCond
     * @param evt
     */
    private void txtcedulaCondKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaCondKeyReleased
        // TODO add your handling code here:
        lbllicenCond.setText(txtcedulaCond.getText());
    }//GEN-LAST:event_txtcedulaCondKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmHistorialEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHistorialEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHistorialEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHistorialEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmHistorialEntrega dialog = new FrmHistorialEntrega(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarenEnvios;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JComboBox<String> cbxcapacidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbllicenCond;
    private javax.swing.JTable tblcamionero;
    private javax.swing.JTextField txtCiudDest;
    private javax.swing.JTextField txtFechEntreg;
    private javax.swing.JTextField txtanioTrabajoCond;
    private javax.swing.JTextField txtcedulaCond;
    private javax.swing.JTextField txtciudCond;
    private javax.swing.JTextField txtciudOrig;
    private javax.swing.JTextField txtdirCond;
    private javax.swing.JTextField txtmarcaCam;
    private javax.swing.JTextField txtnomCond;
    private javax.swing.JTextField txtplacaCam;
    private javax.swing.JTextField txtsueldoCond;
    private javax.swing.JTextField txttelfCond;
    // End of variables declaration//GEN-END:variables
}
