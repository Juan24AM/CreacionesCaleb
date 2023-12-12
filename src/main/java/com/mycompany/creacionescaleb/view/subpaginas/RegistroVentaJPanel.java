/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.creacionescaleb.view.subpaginas;

import com.mycompany.creacionescaleb.dao.DaoVenta;
import com.mycompany.creacionescaleb.dao.impl.DaoVentaImpl;
import com.mycompany.creacionescaleb.entidades.Venta;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.text.Document;

/**
 *
 * @author alumnosis801b
 */
public class RegistroVentaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RegistroVentaJPanel
     */
    Venta venta = new Venta();

    public RegistroVentaJPanel() {
        initComponents();
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
        textTelefono = new javax.swing.JTextField();
        textFecha = new javax.swing.JTextField();
        textPrecio = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        textMetodoPago = new javax.swing.JComboBox<>();
        textDni = new javax.swing.JTextField();
        textTotal = new javax.swing.JTextField();
        textCantidad = new javax.swing.JTextField();
        textDescripcion = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Registro de Venta:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        textTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefono"));
        jPanel1.add(textTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 200, 50));

        textFecha.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha"));
        jPanel1.add(textFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 200, 50));

        textPrecio.setBorder(javax.swing.BorderFactory.createTitledBorder("Precio"));
        jPanel1.add(textPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 200, 50));

        textNombre.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre"));
        jPanel1.add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 200, 50));

        textMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Efectivo", "Tarjeta", "Yape", "Plin" }));
        textMetodoPago.setBorder(javax.swing.BorderFactory.createTitledBorder("Metodo de Pago"));
        jPanel1.add(textMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 200, 50));

        textDni.setBorder(javax.swing.BorderFactory.createTitledBorder("DNI"));
        jPanel1.add(textDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 200, 50));

        textTotal.setBorder(javax.swing.BorderFactory.createTitledBorder("Total"));
        textTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textTotalFocusGained(evt);
            }
        });
        jPanel1.add(textTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 200, 50));

        textCantidad.setBorder(javax.swing.BorderFactory.createTitledBorder("Cantidad"));
        jPanel1.add(textCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 200, 50));

        textDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripcion"));
        jPanel1.add(textDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 200, 50));

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 140, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        DaoVenta dao = new DaoVentaImpl();
        String fecha = textFecha.getText();
        String dni = textDni.getText();
        String nombre = textNombre.getText();
        String telefono = textTelefono.getText();
        String metodoPago = (String) textMetodoPago.getSelectedItem();
        String descripcion = textDescripcion.getText();
        String cantidad = textCantidad.getText();
        String precio = textPrecio.getText();
        String total = textTotal.getText();

        venta.setFecha(fecha);
        venta.setDni(dni);
        venta.setNombre(nombre);
        venta.setTelefono(telefono);
        venta.setMetodoPago(metodoPago);
        venta.setDescripcion(descripcion);
        venta.setCantidad(Integer.parseInt(cantidad));
        venta.setPrecio(Double.parseDouble(precio));
        venta.setTotal(Double.parseDouble(total));

        dao.VentaInsert(venta);

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void textTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textTotalFocusGained
        Integer cantidad = Integer.valueOf(textCantidad.getText());
        Double precio = Double.valueOf(textPrecio.getText());
        Double total = cantidad * precio;
        textTotal.setText(String.valueOf(total));
    }//GEN-LAST:event_textTotalFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textCantidad;
    private javax.swing.JTextField textDescripcion;
    private javax.swing.JTextField textDni;
    private javax.swing.JTextField textFecha;
    private javax.swing.JComboBox<String> textMetodoPago;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textPrecio;
    private javax.swing.JTextField textTelefono;
    private javax.swing.JTextField textTotal;
    // End of variables declaration//GEN-END:variables
}
