/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Dao.ArticuloDao;
import Controlador.ListaDoble.ListaDoble;
import Controlador.Utiles;
import Vistas.Tablas.ModeloTablaArticulos;
import javax.swing.JOptionPane;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class FrmCargarArticulo extends javax.swing.JDialog {

    /**
     * Creates new form FrmCargarArticulo
     */
    private ModeloTablaArticulos modeloArt = new ModeloTablaArticulos();
    private ArticuloDao ad = new ArticuloDao();
    private static ListaDoble articulos = new ListaDoble();
    /**
     * Es la primero que se ejecuta de la vista
     * @param parent sirve para inicializarlo desde otra vista
     * @param modal su ejecucion no terminara hasta que se haya realizado todas las acciones requeridas en esta ventana
     */
    public FrmCargarArticulo(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (RegistroEnvios.getModificacion()) {
            articulos = RegistroEnvios.getEdaoSeleccionado().getEnvio().getPaquete().getContenido();
            ad.setLd(articulos);
            ad.getLd().verDato();
        }
        limpiar();
        cargarTablaA();
    }
    /**
     * @return ListaDoble
     */
    public static ListaDoble getArticulos() {
        if (articulos == null) {
            articulos = new ListaDoble();
        }
        return articulos;
    }
    /**
     * @param articulos
     */
    public static void setArticulos(ListaDoble articulos) {
        FrmCargarArticulo.articulos = articulos;
    }
    /**
     * Carga la informacion almacenada en la listaDoble de los articulos (articulos) para que se vean en una tabla
     */
    private void cargarTablaA() {
        modeloArt.setArticulos(articulos);
        tblarticulos.setModel(modeloArt);
        tblarticulos.updateUI();
    }
    /**
     * Deja en blanco todas las casillas, carga la tabla y deja articulo en nulo
     */
    private void limpiar() {
        txtcantidad.setText("");
        txtnomprod.setText("");
        ad.setArticulo(null);
        Utiles.cargarComboCategorias(cbxcategoria);
        cargarTablaA();
    }
    /**
     * Almacena en el ArticuloDao todo lo escrito en las casillas y se procede a guardar en el .json
     */
    private void guardarArt() {
        try {
            ad.getArticulo().setNombre_articulo(txtnomprod.getText());
            ad.getArticulo().setCantidad(Integer.parseInt(txtcantidad.getText()));
            ad.getArticulo().setCategoria(Utiles.obtenerCategorias(cbxcategoria));
            if (ad.getArticulo().getCantidad() > 0) {
                if (ad.guardar()) {
                    JOptionPane.showMessageDialog(null, "Se ha guardado articulo");
                    articulos = ad.guardarArticulo();
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha guardado articulo");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cantidad menor a lo permitido");
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

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnomprod = new javax.swing.JTextField();
        txtcantidad = new javax.swing.JTextField();
        cbxcategoria = new javax.swing.JComboBox<>();
        btnagregarArt = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblarticulos = new javax.swing.JTable();
        btnagregarpaq = new javax.swing.JButton();
        btneliminarart = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setText("C A R G A R   A R T I C U L O S");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(250, 30, 170, 14);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("REGISTRO ARTICULO"));
        jPanel2.setLayout(null);

        jLabel4.setText("Nombre Producto:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 30, 110, 14);

        jLabel5.setText("Categoria:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 110, 100, 14);

        jLabel6.setText("Cantidad:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 70, 80, 14);
        jPanel2.add(txtnomprod);
        txtnomprod.setBounds(150, 30, 210, 20);
        jPanel2.add(txtcantidad);
        txtcantidad.setBounds(150, 70, 210, 20);

        jPanel2.add(cbxcategoria);
        cbxcategoria.setBounds(150, 110, 200, 20);

        btnagregarArt.setText("AGREGAR ARTICULO");
        btnagregarArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarArtActionPerformed(evt);
            }
        });
        jPanel2.add(btnagregarArt);
        btnagregarArt.setBounds(460, 60, 150, 23);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 50, 660, 170);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("LISTA ARTICULOS"));

        tblarticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Paquete", "Nombre Producto:", "Cantidad:", "Categoria:"
            }
        ));
        jScrollPane1.setViewportView(tblarticulos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 230, 660, 220);

        btnagregarpaq.setText("AGREGAR AL PAQUETE");
        btnagregarpaq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarpaqActionPerformed(evt);
            }
        });
        jPanel1.add(btnagregarpaq);
        btnagregarpaq.setBounds(140, 460, 170, 23);

        btneliminarart.setText("ELIMINAR ARTICULO");
        btneliminarart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarartActionPerformed(evt);
            }
        });
        jPanel1.add(btneliminarart);
        btneliminarart.setBounds(370, 460, 140, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * elimina de la lista y el .json el dato que se ha seleccionado en la tabla de articulos
     * @param evt
     */
    private void btneliminarartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarartActionPerformed
        // TODO add your handling code here:
        if (tblarticulos.getSelectedRow() >= 0) {
            if (articulos.tamano() > 1) {
                articulos.eliminarPorPos(tblarticulos.getSelectedRow());
            } else {
                setArticulos(new ListaDoble());
                ad.setLd(new ListaDoble());
            }

            if (ad.eliminarArt(tblarticulos.getSelectedRow())) {
                JOptionPane.showMessageDialog(null, "Se ha borrado articulo");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha borrado articulo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una celda");
        }
    }//GEN-LAST:event_btneliminarartActionPerformed
    /**
     * Se cambia a la vista FrmRegistroPaqueteCliente
     * @param evt
     */
    private void btnagregarpaqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarpaqActionPerformed
        // TODO add your handling code here:
        new FrmRegistroPaqueteCliente(new javax.swing.JDialog(), true).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnagregarpaqActionPerformed
    /**
     * Comprueba si las casillas estan llenas y cumplen con el tipo de dato asignado a cada atributo de la clase Articulo
     * Manda al metodo guardarArt() para que registre lo ingresado
     * @param evt
     */
    private void btnagregarArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarArtActionPerformed
        // TODO add your handling code here:
        if (!txtcantidad.getText().equals("") && !txtnomprod.getText().equals("")) {
            guardarArt();
        } else {
            JOptionPane.showMessageDialog(null, "Faltan Datos");
        }
    }//GEN-LAST:event_btnagregarArtActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCargarArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCargarArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCargarArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCargarArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmCargarArticulo dialog = new FrmCargarArticulo(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btnagregarArt;
    private javax.swing.JButton btnagregarpaq;
    private javax.swing.JButton btneliminarart;
    private javax.swing.JComboBox<String> cbxcategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblarticulos;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtnomprod;
    // End of variables declaration//GEN-END:variables
}
