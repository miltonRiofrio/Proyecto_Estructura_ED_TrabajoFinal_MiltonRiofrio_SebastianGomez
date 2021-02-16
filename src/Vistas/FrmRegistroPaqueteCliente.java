/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Dao.EnvioDao;
import Controlador.ListaDoble.ListaDoble;
import Controlador.Utiles;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class FrmRegistroPaqueteCliente extends javax.swing.JDialog {

    /**
     * Creates new form FrmRegistroPaqueteCliente
     */
    private EnvioDao ed = new EnvioDao();
    private final int iva = 12; //0.12
    private final double kilo_inicial = 3.75;
    private final double kilo_adicional = 0.75;
    private final int prioridad_baja = 5;   //$0.5 
    private final int prioridad_media = 15; //$1.5 
    private final int prioridad_alta = 25;  //$2.5 
    /**
     * Vista que se ejecuta al llamarla
     * @param parent
     * @param modal
     */
    public FrmRegistroPaqueteCliente(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        limpiar();
        if (RegistroEnvios.getModificacion()) {
            lblfechenvio.setText("" + RegistroEnvios.getEdaoSeleccionado().getEnvio().getPaquete().getFecha_envio());
            cargarPaquete();
        } else {
            lblfechenvio.setText("" + LocalDate.now()); //fecha actual para almacenar en el atributo fecha_envio del paquete
        }
        FrmCargarArticulo.getArticulos().verDato();
    }
    /**
     * Carga todos los datos del paquete que fueron ingresados anteriormente
     */
    private void cargarPaquete() {
        txtci_rucDest.setText(RegistroEnvios.getEdaoSeleccionado().getEnvio().getPaquete().getDestinatario().getCi_ruc());
        txtnomDest.setText(RegistroEnvios.getEdaoSeleccionado().getEnvio().getPaquete().getDestinatario().getNombre());
        txtciuDest.setText(RegistroEnvios.getEdaoSeleccionado().getEnvio().getPaquete().getDestinatario().getCiudad());
        txtdirDest.setText(RegistroEnvios.getEdaoSeleccionado().getEnvio().getPaquete().getDestinatario().getDireccion());
        txttelfDest.setText(RegistroEnvios.getEdaoSeleccionado().getEnvio().getPaquete().getDestinatario().getTelefono());

        txtnomRem.setText(RegistroEnvios.getEdaoSeleccionado().getEnvio().getPaquete().getRemitente().getNombre());
        txtci_rucRem.setText(RegistroEnvios.getEdaoSeleccionado().getEnvio().getPaquete().getRemitente().getCi_ruc());
        txtciuRem.setText(RegistroEnvios.getEdaoSeleccionado().getEnvio().getPaquete().getRemitente().getCiudad());
        txtdirRem.setText(RegistroEnvios.getEdaoSeleccionado().getEnvio().getPaquete().getRemitente().getDireccion());
        txttefRem.setText(RegistroEnvios.getEdaoSeleccionado().getEnvio().getPaquete().getRemitente().getTelefono());

        txtfechentrega.setText("" + RegistroEnvios.getEdaoSeleccionado().getEnvio().getPaquete().getFecha_entrega());
        chbxfragil.setSelected(RegistroEnvios.getEdaoSeleccionado().getEnvio().getPaquete().getFragil());
        txtpeso.setText("" + RegistroEnvios.getEdaoSeleccionado().getEnvio().getPaquete().getPeso());

        System.out.println("Prioridad: " + RegistroEnvios.getEdaoSeleccionado().getEnvio().getPrioridad());

        switch (RegistroEnvios.getEdaoSeleccionado().getEnvio().getPrioridad()) {
            case ALTA:
                cbxpriori.setSelectedIndex(0);
                break;
            case MEDIA:
                cbxpriori.setSelectedIndex(1);
                break;
            default:
                cbxpriori.setSelectedIndex(2);
                break;
        }
    }
    /**
     * Limpia todas las casillas, carga la tabla y deja al envio en nulo
     */
    private void limpiar() {
        ed.setEnvio(null);
        Utiles.cargarComboPrioridades(cbxpriori);
        chbxfragil.setSelected(true);
    }
    /**
     * Calcular el precio de cada paquete segun su peso y prioridad
     * @param peso
     * @param prioridad
     * @return
     */
    private double precioEnvio(double peso, String prioridad) {
        int pesoRound = (int) Math.round(peso) - 1; //convertir el peso en entero recondeado si decimal es >= 5 y restarle 1 (porque se esta obteneiendo el precio por el primer kilo (3.75) antes de esto)
        double subtotal = kilo_inicial + (kilo_adicional * pesoRound); //suma entre el kilo inicial(3.75) mas el kilo adicional(0.75) por el peso
        double total = subtotal + (subtotal * (iva * 0.01)); //suma entre el subtotal normal mas el 12%(iva) del subtotal
        switch (prioridad) { //se le suma al valor total un precio por prioridad dependiendo del que se encoja(Alta, Media, Baja)
            case "Alta":
                return total + (prioridad_alta * 0.1);
            case "Media":
                return total + (prioridad_media * 0.1);
            default:
                return total + (prioridad_baja * 0.1);
        }
    }
    /**
     * Verifica, modifica y guarda todos los datos ingresados referentes al paquete
     * @return
     */
    private boolean guardarP() {
        boolean seGuardo = false;
        try {
            ed.getEnvio().setPrioridad(Utiles.obtenerPrioridades(cbxpriori));
            ed.getEnvio().getPaquete().setContenido(FrmCargarArticulo.getArticulos());
            ed.getEnvio().getPaquete().getDestinatario().setNombre(txtnomDest.getText());
            ed.getEnvio().getPaquete().getDestinatario().setCi_ruc(txtci_rucDest.getText());
            ed.getEnvio().getPaquete().getDestinatario().setCiudad(txtciuDest.getText());
            ed.getEnvio().getPaquete().getDestinatario().setDireccion(txtdirDest.getText());
            ed.getEnvio().getPaquete().getDestinatario().setTelefono(txttelfDest.getText());
            ed.getEnvio().getPaquete().getRemitente().setNombre(txtnomRem.getText());
            ed.getEnvio().getPaquete().getRemitente().setCi_ruc(txtci_rucRem.getText());
            ed.getEnvio().getPaquete().getRemitente().setCiudad(txtciuRem.getText());
            ed.getEnvio().getPaquete().getRemitente().setDireccion(txtdirRem.getText());
            ed.getEnvio().getPaquete().getRemitente().setTelefono(txttefRem.getText());
            //*******cambiar el formato txtfechaentrega de String a Date
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = df.format(Date.valueOf(txtfechentrega.getText()));
            ed.getEnvio().getPaquete().setFecha_entrega(Date.valueOf(fecha));
            //**********************************************************
            ed.getEnvio().getPaquete().setFecha_envio(Date.valueOf(lblfechenvio.getText())); //fecha_envio 
            ed.getEnvio().getPaquete().setFragil(chbxfragil.isSelected());
            ed.getEnvio().getPaquete().setPeso(Double.parseDouble(txtpeso.getText()));
            ed.getEnvio().setPrecio(precioEnvio(ed.getEnvio().getPaquete().getPeso(), ed.getEnvio().getPrioridad().toString()));

            if (ed.getEnvio().getPaquete().getFecha_entrega().after(ed.getEnvio().getPaquete().getFecha_envio())) {
                if (ed.getEnvio().getPaquete().getPeso() > 0.0 && ed.getEnvio().getPaquete().getPeso() < 100.0) {
                    if (RegistroEnvios.getModificacion()) {
                        ed.getEnvio().setId_envio(RegistroEnvios.getEdaoSeleccionado().getEnvio().getId_envio());
                        ed.getEnvio().getPaquete().setId_paquete(RegistroEnvios.getEdaoSeleccionado().getEnvio().getPaquete().getId_paquete());
                        ed.getEnvio().setEstado(RegistroEnvios.getEdaoSeleccionado().getEnvio().getEstado());
                        ed.getEnvio().setHist_entrega(RegistroEnvios.getEdaoSeleccionado().getEnvio().getHist_entrega());

                        if (ed.modificarEnvio()) {
                            JOptionPane.showMessageDialog(null, "Se ha modificar paquete al envio");
                            seGuardo = true;
                            limpiar();
                        } else {
                            JOptionPane.showMessageDialog(null, "No se ha modificar paquete al envio");
                        }
                    } else {
                        ed.getEnvio().setEstado("pendiente");
                        ed.getEnvio().setHist_entrega(new ListaDoble());

                        if (ed.guardar()) {
                            JOptionPane.showMessageDialog(null, "Se ha guardado paquete al envio");
                            seGuardo = true;
                            limpiar();
                        } else {
                            JOptionPane.showMessageDialog(null, "No se ha guardado paquete al envio");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Peso fuera del limite");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fecha de Entrega debe ser mayor a la Fecha de Envio");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos erroneos: " + e);
        }
        return seGuardo;
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
        btnagregarPaq = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnomDest = new javax.swing.JTextField();
        txtci_rucDest = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txttelfDest = new javax.swing.JTextField();
        txtciuDest = new javax.swing.JTextField();
        txtdirDest = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtpeso = new javax.swing.JTextField();
        txtfechentrega = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbxpriori = new javax.swing.JComboBox<>();
        chbxfragil = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        lblfechenvio = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtdirRem = new javax.swing.JTextField();
        txtci_rucRem = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txttefRem = new javax.swing.JTextField();
        txtnomRem = new javax.swing.JTextField();
        txtciuRem = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setText("R E G I S T R O   P A Q U E T E   D E   C L I E N T E");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(360, 30, 290, 14);

        btnagregarPaq.setText("AGREGAR PAQUETE");
        btnagregarPaq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarPaqActionPerformed(evt);
            }
        });
        jPanel1.add(btnagregarPaq);
        btnagregarPaq.setBounds(420, 500, 150, 23);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("REGISTRO DEL DESTINATARIO"));
        jPanel2.setLayout(null);

        jLabel2.setText("Nombre:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 40, 70, 14);

        jLabel3.setText("CI/RUC:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 80, 70, 14);
        jPanel2.add(txtnomDest);
        txtnomDest.setBounds(140, 40, 250, 20);
        jPanel2.add(txtci_rucDest);
        txtci_rucDest.setBounds(140, 80, 250, 20);

        jLabel4.setText("Telefono:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 120, 60, 14);

        jLabel5.setText("Ciudad:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 160, 41, 14);

        jLabel6.setText("Direccion:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 200, 70, 14);
        jPanel2.add(txttelfDest);
        txttelfDest.setBounds(140, 120, 250, 20);
        jPanel2.add(txtciuDest);
        txtciuDest.setBounds(140, 160, 250, 20);
        jPanel2.add(txtdirDest);
        txtdirDest.setBounds(140, 200, 250, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 70, 480, 240);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("REGISTRO PAQUETE CLIENTE"));
        jPanel3.setLayout(null);

        jLabel8.setText("Peso (Kg):");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(30, 40, 83, 14);

        jLabel9.setText("Fragilidad:");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(440, 90, 83, 14);

        jLabel10.setText("Fecha de envio:");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(440, 40, 90, 14);
        jPanel3.add(txtpeso);
        txtpeso.setBounds(150, 40, 260, 20);
        jPanel3.add(txtfechentrega);
        txtfechentrega.setBounds(150, 90, 260, 20);

        jLabel11.setText("Prioridad:");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(740, 60, 60, 14);

        cbxpriori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxprioriMouseClicked(evt);
            }
        });
        jPanel3.add(cbxpriori);
        cbxpriori.setBounds(840, 60, 120, 20);

        chbxfragil.setText("Es Fragil");
        jPanel3.add(chbxfragil);
        chbxfragil.setBounds(530, 90, 85, 23);

        jLabel7.setText("Fecha de Entrega:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(30, 90, 89, 14);
        jPanel3.add(lblfechenvio);
        lblfechenvio.setBounds(540, 40, 170, 20);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 340, 1010, 140);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("REGISTRO DE REMITENTE"));
        jPanel4.setLayout(null);
        jPanel4.add(txtdirRem);
        txtdirRem.setBounds(160, 200, 250, 20);
        jPanel4.add(txtci_rucRem);
        txtci_rucRem.setBounds(160, 80, 250, 20);

        jLabel17.setText("Direccion:");
        jPanel4.add(jLabel17);
        jLabel17.setBounds(40, 200, 70, 14);
        jPanel4.add(txttefRem);
        txttefRem.setBounds(160, 120, 250, 20);
        jPanel4.add(txtnomRem);
        txtnomRem.setBounds(160, 40, 250, 20);
        jPanel4.add(txtciuRem);
        txtciuRem.setBounds(160, 160, 250, 20);

        jLabel16.setText("Ciudad:");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(40, 160, 41, 14);

        jLabel13.setText("Nombre:");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(40, 40, 70, 14);

        jLabel14.setText("CI/RUC:");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(40, 80, 80, 14);

        jLabel15.setText("Telefono:");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(40, 120, 60, 14);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(530, 70, 490, 240);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Verifica la correcta escritura de lo ingresado, procede a guardarlos y carga la tabla RegistroEnvios
     * @param evt
     */
    private void btnagregarPaqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarPaqActionPerformed
        // TODO add your handling code here:
        try {
        if (txtci_rucDest.getText().matches("^[0-9]{10}|[0-9]{13}$") && txtci_rucRem.getText().matches("^[0-9]{10}|[0-9]{13}$")) {
            if (txttefRem.getText().matches("^09[0-9]{8}$") && txttelfDest.getText().matches("^09[0-9]{8}$")) {
                if (!txtpeso.getText().equals("") && !txtciuDest.getText().equals("") && !txtciuRem.getText().equals("") && !txtdirDest.getText().equals("") && !txtdirRem.getText().equals("") && !txtnomDest.getText().equals("") && !txtnomRem.getText().equals("")) {
                    if (guardarP()) {
                        FrmCargarArticulo.setArticulos(new ListaDoble());
                        new RegistroEnvios().setVisible(true);
                        this.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Faltan Datos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Telefono Incompleto o fuera de rango");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cedula Incompleta o fuera de rango");
        }
        } catch (Exception e) {
           System.out.println("error: " + e);
        }
    }//GEN-LAST:event_btnagregarPaqActionPerformed
    /**
     * @param evt
     */
    private void cbxprioriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxprioriMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxprioriMouseClicked

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
            java.util.logging.Logger.getLogger(FrmRegistroPaqueteCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistroPaqueteCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistroPaqueteCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistroPaqueteCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmRegistroPaqueteCliente dialog = new FrmRegistroPaqueteCliente(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnagregarPaq;
    private javax.swing.JComboBox<String> cbxpriori;
    private javax.swing.JCheckBox chbxfragil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblfechenvio;
    private javax.swing.JTextField txtci_rucDest;
    private javax.swing.JTextField txtci_rucRem;
    private javax.swing.JTextField txtciuDest;
    private javax.swing.JTextField txtciuRem;
    private javax.swing.JTextField txtdirDest;
    private javax.swing.JTextField txtdirRem;
    private javax.swing.JTextField txtfechentrega;
    private javax.swing.JTextField txtnomDest;
    private javax.swing.JTextField txtnomRem;
    private javax.swing.JTextField txtpeso;
    private javax.swing.JTextField txttefRem;
    private javax.swing.JTextField txttelfDest;
    // End of variables declaration//GEN-END:variables
}
