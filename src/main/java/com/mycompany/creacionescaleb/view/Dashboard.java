/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.creacionescaleb.view;

import com.mycompany.creacionescaleb.dao.DaoUsuario;
import com.mycompany.creacionescaleb.dao.impl.DaoUsuarioImpl;
import com.mycompany.creacionescaleb.entidades.Usuario;
import com.mycompany.creacionescaleb.util.CodificarDecoficarBase64;
import com.mycompany.creacionescaleb.view.subpaginas.HomeJPanel;
import com.mycompany.creacionescaleb.view.subpaginas.InventarioJPanel;
import com.mycompany.creacionescaleb.view.subpaginas.RegistroInventarioJPanel;
import com.mycompany.creacionescaleb.view.subpaginas.PerfilJPanel;
import com.mycompany.creacionescaleb.view.subpaginas.VentasJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author USER
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    
    LocalDate dateNow =  LocalDate.now();
    LocalTime timeNow = LocalTime.now();
    private Usuario usuarioLogin = new Usuario();
    
    public Dashboard() {
        initComponents();
        initContent();
    }
    
    public Dashboard(Usuario user) {
        this.usuarioLogin = user;
        initComponents();
        
        setDate();
        setBienvenida();
        initContent();
    }
    
    private void setDate(){
        Locale spanishLocale = new Locale("es", "PE");
        String textDate = dateNow.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale));
        dateText.setText(textDate);
    }
    
    private void setBienvenida() {
        // Establecer límites de tiempo
        LocalTime limiteManana = LocalTime.parse("11:55:00");
        LocalTime limiteTarde = LocalTime.parse("18:00:00");
        
        // Determinar el saludo según la hora actual
        String saludo;
        if (timeNow.isBefore(limiteManana)) {
            saludo = "mañana";
        } else if (timeNow.isBefore(limiteTarde)) {
            saludo = "tarde";
        } else {
            saludo = "noche";
        }
        
        String textBienvenida = String.format("Bienvenido %s, que tengas una excelente %s.", usuarioLogin.getNombres(), saludo);
        bienvenidaText.setText(textBienvenida);
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
    
    private void initContent() {
        setColorButtons("Home");
        HomeJPanel hm = new HomeJPanel();
        showJPanel(hm);
    }
    
    public static void showJPanel (JPanel p) {
        p.setSize(740, 480);
        p.setLocation(0, 0);
        
        content.removeAll();
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        btnPerfil = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bienvenidaText = new javax.swing.JLabel();
        dateText = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1020, 640));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1020, 640));
        background.setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(121, 89, 70));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Creaciones Caleb");

        btnHome.setBackground(new java.awt.Color(150, 127, 113));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home.png"))); // NOI18N
        btnHome.setText("Home");
        btnHome.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        btnHome.setBorderPainted(false);
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome.setIconTextGap(15);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnPerfil.setBackground(new java.awt.Color(150, 127, 113));
        btnPerfil.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPerfil.setForeground(new java.awt.Color(255, 255, 255));
        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N
        btnPerfil.setText("Perfil");
        btnPerfil.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        btnPerfil.setBorderPainted(false);
        btnPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPerfil.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPerfil.setIconTextGap(15);
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });

        btnVentas.setBackground(new java.awt.Color(150, 127, 113));
        btnVentas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coupon.png"))); // NOI18N
        btnVentas.setText("Ventas");
        btnVentas.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        btnVentas.setBorderPainted(false);
        btnVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVentas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVentas.setIconTextGap(15);
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnClientes.setBackground(new java.awt.Color(150, 127, 113));
        btnClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/costumer.png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        btnClientes.setBorderPainted(false);
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnClientes.setIconTextGap(15);

        btnInventario.setBackground(new java.awt.Color(150, 127, 113));
        btnInventario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInventario.setForeground(new java.awt.Color(255, 255, 255));
        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shipping.png"))); // NOI18N
        btnInventario.setText("Inventario");
        btnInventario.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        btnInventario.setBorderPainted(false);
        btnInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInventario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInventario.setIconTextGap(15);
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        btnUsuarios.setBackground(new java.awt.Color(150, 127, 113));
        btnUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multiple-users-silhouette.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 15, 1, 1, new java.awt.Color(0, 0, 0)));
        btnUsuarios.setBorderPainted(false);
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUsuarios.setIconTextGap(15);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );

        jPanel2.setBackground(new java.awt.Color(203, 191, 184));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administracion/Control/CreacionesCaleb");

        bienvenidaText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bienvenidaText.setForeground(new java.awt.Color(255, 255, 255));
        bienvenidaText.setText("Bienvenido {name}, que tengas una excelente {ciclohorario}.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(bienvenidaText, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bienvenidaText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        dateText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateText.setForeground(new java.awt.Color(150, 127, 113));
        dateText.setText("Hoy es {datename} de {month} de {year}");

        content.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(dateText))
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(dateText)
                .addGap(11, 11, 11)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        String butonName = btnPerfil.getText();
        setColorButtons(butonName);
        PerfilJPanel pf;
        if (usuarioLogin.getNombres() != null) {
            DaoUsuario dao = new DaoUsuarioImpl();
            Usuario userActualizado = dao.usuarioLogin(usuarioLogin.getDni(), usuarioLogin.getPassword());
            pf = new PerfilJPanel(userActualizado);
            showJPanel(pf);
            SwingUtilities.invokeLater(() -> pf.setFotoPersona());
        } else {
            pf = new PerfilJPanel();
            showJPanel(pf);
        }
        
        
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        String butonName = btnVentas.getText();
        setColorButtons(butonName);
        VentasJPanel vts;
        if (usuarioLogin.getNombres() != null) {
            vts = new VentasJPanel();
        } else {
            vts = new VentasJPanel();
        }
        showJPanel(vts);
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        String butonName = btnHome.getText();
        setColorButtons(butonName);
        initContent();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        String butonName = btnInventario.getText();
        setColorButtons(butonName);
        /* 
        RegistroInventarioJPanel invt;
        if (usuarioLogin.getNombres() != null) {
            invt = new RegistroInventarioJPanel();
        } else {
            invt = new RegistroInventarioJPanel();
        }
        showJPanel(invt);
        SwingUtilities.invokeLater(() -> invt.setFotoProducto());*/
        InventarioJPanel invt = new InventarioJPanel();
        showJPanel(invt);
        
        
    }//GEN-LAST:event_btnInventarioActionPerformed
    
    public void setColorButtons(String name) {
        setDefaultColorBotones();
        Color colorSelect = new Color(203, 191, 184);
        switch (name) {
            case "Home" -> btnHome.setBackground(colorSelect);
            case "Perfil" -> btnPerfil.setBackground(colorSelect);
            case "Ventas" -> btnVentas.setBackground(colorSelect);
            case "Clientes" -> btnClientes.setBackground(colorSelect);
            case "Inventario" -> btnInventario.setBackground(colorSelect);
            case "Usuarios" -> btnUsuarios.setBackground(colorSelect);
        }
        
    }
    
    private void setDefaultColorBotones() {
        Color Colordefult = new Color(150,127,113);
        btnHome.setBackground(Colordefult);
        btnPerfil.setBackground(Colordefult);
        btnVentas.setBackground(Colordefult);
        btnClientes.setBackground(Colordefult);
        btnInventario.setBackground(Colordefult);
        btnUsuarios.setBackground(Colordefult);
    }
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
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel bienvenidaText;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnPerfil;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnVentas;
    private static javax.swing.JPanel content;
    private javax.swing.JLabel dateText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
