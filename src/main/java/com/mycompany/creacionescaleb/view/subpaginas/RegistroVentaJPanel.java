/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.creacionescaleb.view.subpaginas;

import com.mycompany.creacionescaleb.dao.DaoProducto;
import com.mycompany.creacionescaleb.dao.DaoVenta;
import com.mycompany.creacionescaleb.dao.impl.DaoProductoImpl;
import com.mycompany.creacionescaleb.dao.impl.DaoVentaImpl;
import com.mycompany.creacionescaleb.entidades.Producto;
import com.mycompany.creacionescaleb.entidades.Venta;
import com.mycompany.creacionescaleb.util.ApiReniec;
import com.mycompany.creacionescaleb.util.CodificarDecoficarBase64;
import com.mycompany.creacionescaleb.view.Dashboard;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.text.Document;

/**
 *
 * @author alumnosis801b
 */
public class RegistroVentaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RegistroVentaJPanel
     */
    DaoProducto dao = new DaoProductoImpl();
    DaoVenta daoventa = new DaoVentaImpl();
    Venta venta = new Venta();
    Producto prodSeleccionado;
    boolean isEdition = false;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public RegistroVentaJPanel() {
        initComponents();
        listarCodProductos();
        initComboBoxListener();
    }

    public RegistroVentaJPanel(Venta venta) {
        initComponents();
        listarCodProductos();
        this.venta = venta;
        isEdition = true;
        initComboBoxListener();
    }

    private void initComboBoxListener() {
        textProducto.addActionListener((ActionEvent e) -> {
            String seleccion = (String) textProducto.getSelectedItem();
            if (!seleccion.equalsIgnoreCase("Seleccionar")) {
                prodSeleccionado = dao.productoGet(Integer.valueOf(seleccion));
                if (!isEdition) {
                    textDescripcion.setText(prodSeleccionado.getDescripcion());
                    labelStock.setText(String.format("Stock Disponible: %d", prodSeleccionado.getStock()));
                }
                textPrecio.setText(String.valueOf(prodSeleccionado.getPrecio()));
                labelNomProducto.setText(prodSeleccionado.getNombre());
                setFotoInLabel(jLabel10, prodSeleccionado.getFotoProducto(), null);
            } else {
                textDescripcion.setText("");
                textPrecio.setText("");
                labelNomProducto.setText("");
                labelStock.setText("");
                jLabel10.setIcon(null);
            }
        });
    }

    public void editionMode() {
        if (isEdition) {
            labelStock.setText("");
            jLabel1.setText("Edicion de venta:");
            btnAgregar.setText("EDITAR");

            textDni.setText(venta.getDni());
            textNombre.setText(venta.getNombre());
            textTelefono.setText(venta.getTelefono());
            String prodcitoEdit = venta.getIdProducto().toString();
            textProducto.setSelectedItem(prodcitoEdit);
            String metPagoEdit = venta.getMetodoPago();
            textMetodoPago.setSelectedItem(metPagoEdit);
            textDescripcion.setText(venta.getDescripcion());
            textCantidad.setText(String.valueOf(venta.getCantidad()));
            textPrecio.setText(String.valueOf(venta.getPrecio()));
            textTotal.setText(String.valueOf(venta.getTotal()));
            try {
                jDateFecha.setDate(formato.parse(venta.getFecha()));
                prodSeleccionado = dao.productoGet(venta.getIdProducto());
                setFotoInLabel(jLabel10, prodSeleccionado.getFotoProducto(), null);
                // labelNomProducto.setText(prodSeleccionado.getNombre());
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                jLabel10.setIcon(null);
                // labelNomProducto.setText("");
            }
        }
    }

    public void listarCodProductos() {
        try {
            dao.productoLista().forEach((u) -> textProducto.addItem(String.valueOf(u.getId())));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void limpiarCampos() {
        jDateFecha.setDate(null);
        textDni.setText("");
        textNombre.setText("");
        textTelefono.setText("");
        textProducto.setSelectedIndex(0);
        textMetodoPago.setSelectedIndex(0);
        textCantidad.setText("");
        textTotal.setText("");
    }

    private void setFotoInLabel(JLabel labelName, String base64Image, String root) {
        ImageIcon image = null;
        if (root == null) {
            byte[] fotoPersona = CodificarDecoficarBase64.decodeImage(base64Image);
            image = new ImageIcon(fotoPersona);
        } else {
            String fotoPersona = root;
            image = new ImageIcon(fotoPersona);
        }

        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();
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
        textPrecio = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        textProducto = new javax.swing.JComboBox<>();
        textDni = new javax.swing.JTextField();
        textTotal = new javax.swing.JTextField();
        textCantidad = new javax.swing.JTextField();
        textDescripcion = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jDateFecha = new com.toedter.calendar.JDateChooser();
        textMetodoPago = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        labelNomProducto = new javax.swing.JLabel();
        labelStock = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Registro de Venta:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        textTelefono.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefono"));
        jPanel1.add(textTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 230, 50));

        textPrecio.setBorder(javax.swing.BorderFactory.createTitledBorder("Precio"));
        jPanel1.add(textPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 200, 50));

        textNombre.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre"));
        jPanel1.add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 230, 50));

        textProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        textProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Cod. Producto"));
        jPanel1.add(textProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 230, 50));

        textDni.setBorder(javax.swing.BorderFactory.createTitledBorder("DNI"));
        textDni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textDniFocusLost(evt);
            }
        });
        jPanel1.add(textDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 230, 50));

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

        jDateFecha.setBackground(new java.awt.Color(255, 255, 255));
        jDateFecha.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha"));
        jDateFecha.setForeground(new java.awt.Color(0, 153, 153));
        jDateFecha.setDateFormatString("dd/MM/yyyy");
        jPanel1.add(jDateFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 230, 50));

        textMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Efectivo", "Tarjeta", "Yape", "Plin" }));
        textMetodoPago.setBorder(javax.swing.BorderFactory.createTitledBorder("Metodo de Pago"));
        jPanel1.add(textMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 200, 50));
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 160, 170));

        labelNomProducto.setText("{Nombre producto}");
        jPanel1.add(labelNomProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, -1, -1));

        labelStock.setText("{Stock Disponible}");
        jPanel1.add(labelStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, -1));

        jButton1.setText("REGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, 140, 50));

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
        daoventa = new DaoVentaImpl();
        Integer idProducto = Integer.valueOf(textProducto.getSelectedItem().toString());
        String fecha = formato.format(jDateFecha.getDate());
        String dni = textDni.getText();
        String nombre = textNombre.getText();
        String telefono = textTelefono.getText();
        String metodoPago = (String) textMetodoPago.getSelectedItem();
        String descripcion = textDescripcion.getText();
        Integer cantidad = Integer.valueOf(textCantidad.getText());
        String precio = textPrecio.getText();
        // String total = textTotal.getText();

        if (!isEdition) {
            if (cantidad > prodSeleccionado.getStock()) {
                javax.swing.JOptionPane.showMessageDialog(this, "No hay stock suficiente.", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        venta.setIdProducto(idProducto);
        venta.setFecha(fecha);
        venta.setDni(dni);
        venta.setNombre(nombre);
        venta.setTelefono(telefono);
        venta.setMetodoPago(metodoPago);
        venta.setDescripcion(descripcion);
        venta.setCantidad(cantidad);
        venta.setPrecio(Double.parseDouble(precio));
        venta.setTotal(Double.valueOf(precio) * cantidad);
        
        String estadoInsercion;
        
        if (!isEdition) {
            estadoInsercion = daoventa.VentaInsert(venta);
        } else {
            estadoInsercion = daoventa.VentaUptdate(venta);
        }
        
        String successMsg = isEdition ? "Edicion" : "Venta";
        
        if (estadoInsercion == null) {
            javax.swing.JOptionPane.showMessageDialog(this, successMsg + " realizada correctamente.", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            if (!isEdition) {
                dao.ProductoActualizarStock(idProducto, cantidad);
                limpiarCampos();
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "No se puedo realizar la " + successMsg + ".", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            System.out.println(estadoInsercion);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void textTotalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textTotalFocusGained
        String cant = textCantidad.getText();
        String regex = "\\d+";
        if (cant.matches(regex)) {
            Integer cantidad = Integer.valueOf(cant);
            Double precio = Double.valueOf(textPrecio.getText());
            Double total = cantidad * precio;
            textTotal.setText(String.valueOf(total));
        }
    }//GEN-LAST:event_textTotalFocusGained

    private void textDniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textDniFocusLost
        String dni = textDni.getText();
        String regex = "\\d{8}";
        if (dni.matches(regex)) {
            ApiReniec persona = new ApiReniec(dni);
            textNombre.setText(String.format("%s %s %s", persona.getNombre(), persona.getPaterno(), persona.getMaterno()));
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "El DNI no es válido. Asegúrate de ingresar solo números y que la longitud sea 8.", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_textDniFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentasJPanel invt = new VentasJPanel();
        Dashboard.showJPanel(invt);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateFecha;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelNomProducto;
    private javax.swing.JLabel labelStock;
    private javax.swing.JTextField textCantidad;
    private javax.swing.JTextField textDescripcion;
    private javax.swing.JTextField textDni;
    private javax.swing.JComboBox<String> textMetodoPago;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textPrecio;
    private javax.swing.JComboBox<String> textProducto;
    private javax.swing.JTextField textTelefono;
    private javax.swing.JTextField textTotal;
    // End of variables declaration//GEN-END:variables
}
