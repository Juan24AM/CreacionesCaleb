/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.creacionescaleb.view.subpaginas;

import com.mycompany.creacionescaleb.dao.DaoUsuario;
import com.mycompany.creacionescaleb.dao.impl.DaoUsuarioImpl;
import com.mycompany.creacionescaleb.entidades.Usuario;
import com.mycompany.creacionescaleb.util.ApiReniec;
import com.mycompany.creacionescaleb.util.CodificarDecoficarBase64;
import com.mycompany.creacionescaleb.view.Dashboard;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author USER
 */
public class RegistroUsuarioJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RegistroUsuarioJPanel
     */
    boolean isEdition = false;
    Date dateNow = new Date();
    ApiReniec persona;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    Usuario usuarioNuevo = new Usuario();
    Usuario usuarioResponsable = new Usuario();
    DaoUsuario daousuario = new DaoUsuarioImpl();

    public RegistroUsuarioJPanel() {
        initComponents();
        dateFeCreacion.setDate(dateNow);
    }

    public RegistroUsuarioJPanel(Usuario user, boolean edition) {
        initComponents();
        this.usuarioResponsable = user;
        this.isEdition = edition;
        if(!isEdition) {
            dateFeCreacion.setDate(dateNow);
            jLabel2.setText(String.format("RESPONSABLE: %s %s (%s)", user.getNombres(), user.getPaterno(), user.getDni()));
        } else {
            editionMode();
            dateFeCreacion.setEnabled(false);
        }
    }

    public void editionMode() {
        if (isEdition) {
            jLabel1.setText("Edicion de usuario existente:");
            btnAgregarEditar.setText("EDITAR");

            textDni.setText(usuarioResponsable.getDni());
            txtNombres.setText(usuarioResponsable.getNombres());
            textPaterno.setText(usuarioResponsable.getPaterno());
            textMaterno.setText(usuarioResponsable.getMaterno());
            boxGenero.setSelectedItem(usuarioResponsable.getGenero());
            textCorreo.setText(usuarioResponsable.getCorreo());
            boxTipoUsuario.setSelectedItem(usuarioResponsable.getTipoUsuario());
            textNomUsuario.setText(usuarioResponsable.getUsername());
            pswPassword.setText(usuarioResponsable.getPassword());
            pswPasswordConfirm.setText(usuarioResponsable.getPassword());
            
            jLabel2.setText(String.format("USUARIO CREADO POR (%s)", usuarioResponsable.getDniResponsable()));
            
            
            
            try {
                dateFeNacimiento.setDate(formato.parse(usuarioResponsable.getFeNacimiento()));
                dateFeCreacion.setDate(formato.parse(usuarioResponsable.getFeCreacion()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
        }
    }
    
    public void setImageEdit() {
        setFotoInLabel(textIconFoto, usuarioResponsable.getFoto(), null);
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
        textNomUsuario = new javax.swing.JTextField();
        textDni = new javax.swing.JTextField();
        textCorreo = new javax.swing.JTextField();
        textPaterno = new javax.swing.JTextField();
        boxTipoUsuario = new javax.swing.JComboBox<>();
        dateFeCreacion = new com.toedter.calendar.JDateChooser();
        txtNombres = new javax.swing.JTextField();
        dateFeNacimiento = new com.toedter.calendar.JDateChooser();
        boxGenero = new javax.swing.JComboBox<>();
        textMaterno = new javax.swing.JTextField();
        pswPasswordConfirm = new javax.swing.JPasswordField();
        pswPassword = new javax.swing.JPasswordField();
        textIconFoto = new javax.swing.JLabel();
        btnAgregarEditar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnBuscarDNI = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Registro de nuevo usuario:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 240, -1));

        textNomUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre de Usuario"));
        jPanel1.add(textNomUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 210, 50));

        textDni.setBorder(javax.swing.BorderFactory.createTitledBorder("DNI"));
        jPanel1.add(textDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 150, 50));

        textCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder("Correo"));
        jPanel1.add(textCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 210, 50));

        textPaterno.setBorder(javax.swing.BorderFactory.createTitledBorder("Apellido Paterno"));
        jPanel1.add(textPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 210, 50));

        boxTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "USUARIO", "ADMIN", "DESPEDIDO" }));
        boxTipoUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Usuario"));
        jPanel1.add(boxTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 210, 40));

        dateFeCreacion.setBackground(new java.awt.Color(255, 255, 255));
        dateFeCreacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha Creacion"));
        dateFeCreacion.setForeground(new java.awt.Color(0, 153, 153));
        dateFeCreacion.setDateFormatString("dd/MM/yyyy");
        jPanel1.add(dateFeCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 210, 60));

        txtNombres.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombres"));
        jPanel1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 210, 50));

        dateFeNacimiento.setBackground(new java.awt.Color(255, 255, 255));
        dateFeNacimiento.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha Nacimiento"));
        dateFeNacimiento.setForeground(new java.awt.Color(0, 153, 153));
        dateFeNacimiento.setDateFormatString("dd/MM/yyyy");
        jPanel1.add(dateFeNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 210, 60));

        boxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "MASCULINO", "FEMENINO" }));
        boxGenero.setBorder(javax.swing.BorderFactory.createTitledBorder("Genero"));
        jPanel1.add(boxGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 210, 40));

        textMaterno.setBorder(javax.swing.BorderFactory.createTitledBorder("Apellido Materno"));
        jPanel1.add(textMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 210, 50));

        pswPasswordConfirm.setBorder(javax.swing.BorderFactory.createTitledBorder("Confirmar Contraseña"));
        jPanel1.add(pswPasswordConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 210, 50));

        pswPassword.setBorder(javax.swing.BorderFactory.createTitledBorder("Contraseña"));
        jPanel1.add(pswPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 210, 50));
        jPanel1.add(textIconFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 160, 220));

        btnAgregarEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pen.png"))); // NOI18N
        btnAgregarEditar.setText("Agregar");
        btnAgregarEditar.setBorder(null);
        btnAgregarEditar.setBorderPainted(false);
        btnAgregarEditar.setContentAreaFilled(false);
        btnAgregarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 420, 120, 40));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/left-arrow.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setBorder(null);
        btnRegresar.setBorderPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, 120, 40));

        btnBuscarDNI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/searching.png"))); // NOI18N
        btnBuscarDNI.setBorder(null);
        btnBuscarDNI.setBorderPainted(false);
        btnBuscarDNI.setContentAreaFilled(false);
        btnBuscarDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDNIActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 60, 50));

        jLabel2.setText("RESPONSABLE: {nombre} ({dni})");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 380, -1));

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Mostar");
        jCheckBox1.setContentAreaFilled(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEditarActionPerformed
        
        String campos = validarCampos();
        if(!campos.equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, String.format("Por favor verifica %s", campos), "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String dni = textDni.getText();
        String nombre = txtNombres.getText();
        String paterno = textPaterno.getText();
        String materno = textMaterno.getText();
        String genero = boxGenero.getSelectedItem().toString();
        String feNacimiento = formato.format(dateFeNacimiento.getDate());
        String correo = textCorreo.getText().toUpperCase();
        String feCreacion = formato.format(dateFeCreacion.getDate());
        String tipoUsuario = boxTipoUsuario.getSelectedItem().toString();
        String nomUsuario = textNomUsuario.getText().toUpperCase();
        String p1 = new String(pswPassword.getPassword());
        String p2 = new String(pswPasswordConfirm.getPassword());

        if (!p1.equals(p2)) {
            javax.swing.JOptionPane.showMessageDialog(this, "La contraseña no coincide, por favor verifica.", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (isEdition)
            usuarioNuevo = usuarioResponsable;
        
        usuarioNuevo.setDni(dni);
        usuarioNuevo.setNombres(nombre);
        usuarioNuevo.setPaterno(paterno);
        usuarioNuevo.setMaterno(materno);
        usuarioNuevo.setGenero(genero);
        usuarioNuevo.setFeNacimiento(feNacimiento);
        usuarioNuevo.setEdad(calcularEdad(feNacimiento));
        usuarioNuevo.setCorreo(correo);
        usuarioNuevo.setFeCreacion(feCreacion);
        if (!isEdition)
            usuarioNuevo.setDniResponsable(usuarioResponsable.getDni());
        usuarioNuevo.setTipoUsuario(tipoUsuario);
        usuarioNuevo.setUsername(nomUsuario);
        usuarioNuevo.setPassword(p1);

        String insert;
        if (!isEdition) {
            insert = daousuario.UsuarioInsert(usuarioNuevo);
        } else {
            insert = daousuario.UsuarioUptdate(usuarioNuevo);
        }
        
        String successMsg = isEdition ? "modificado" : "registrado";
        
        if(insert == null) {
            javax.swing.JOptionPane.showMessageDialog(this,String.format("Usuario %s correctamente.", successMsg), "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            if (!isEdition)
                limpiarCampos();
        } else {
            javax.swing.JOptionPane.showMessageDialog(this,String.format("No se ha podido %s al usuario, revisa los detalles: %s", successMsg,insert), "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarEditarActionPerformed
    
    public Integer calcularEdad(String dateNacimiento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(dateNacimiento, formatter);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNac, fechaActual);
        int edad = periodo.getYears();
        return edad;
    }
    
    public String validarCampos() {
        StringBuilder errores = new StringBuilder();
        String regexDni = "\\d{8}";
        String regexNom = "^[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ\\s'-]+$";
        String regexCorreo = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String p1 = new String(pswPassword.getPassword());
        String p2 = new String(pswPasswordConfirm.getPassword());

        if (!textDni.getText().matches(regexDni)) {
            errores.append("DNI, ");
        }

        if (!txtNombres.getText().matches(regexNom)) {
            errores.append("Nombre, ");
        }

        if (!textPaterno.getText().matches(regexNom)) {
            errores.append("Apellido Paterno, ");
        }

        if (!textMaterno.getText().matches(regexNom)) {
            errores.append("Apellido Materno, ");
        }
        
        if (dateFeNacimiento.getDate() == null) {
            errores.append("Fecha de nacimiento, ");
        }
        
        if (boxGenero.getSelectedItem().equals("SELECCIONAR")) {
            errores.append("Género, ");
        }

        if (!textCorreo.getText().matches(regexCorreo)) {
            errores.append("Correo, ");
        }
        
        if (dateFeCreacion.getDate() == null) {
            errores.append("Fecha de creacion, ");
        }
        
        if (boxTipoUsuario.getSelectedItem().equals("SELECCIONAR")) {
            errores.append("Tipo de Usuario, ");
        }

        if (textNomUsuario.getText().isEmpty()) {
            errores.append("Nombre de usuario, ");
        }
        
        if (p1.isEmpty() || p2.isEmpty()) {
            errores.append("Contraseña, ");
        }
        
        // Elimina la coma final si hay errores
        if (errores.length() > 0) {
            errores.setLength(errores.length() - 2);
            errores.append(".");
        }

        return errores.toString();
    }
    
    void limpiarCampos() {
        textDni.setText("");
        txtNombres.setText("");
        textPaterno.setText("");
        textMaterno.setText("");
        boxGenero.setSelectedIndex(0);
        dateFeNacimiento.setDate(null);
        textCorreo.setText("");
        dateFeCreacion.setDate(dateNow);
        boxTipoUsuario.setSelectedIndex(0);
        textNomUsuario.setText("");
        jCheckBox1.setSelected(false);
        pswPassword.setText("");
        pswPasswordConfirm.setText("");
        textIconFoto.setIcon(null);
    }

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        UsuariosJPanel invt = new UsuariosJPanel();
        Dashboard.showJPanel(invt);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBuscarDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDNIActionPerformed
        String dni = textDni.getText();
        String regex = "\\d{8}";
        if (dni.matches(regex)) {
            persona = new ApiReniec(dni, true);
            String respuesta = persona.getRespuesta();
            if (respuesta.equals("0000")) {
                txtNombres.setText(persona.getNombre());
                textPaterno.setText(persona.getPaterno());
                textMaterno.setText(persona.getMaterno());
                boxGenero.setSelectedItem(persona.getGenero());
                String feNacimiento = persona.getFeNacimiento();
                String foto = persona.getFotoPersona();
                setFotoInLabel(textIconFoto, foto, null);

                // Creamos nombre de usuario:
                StringBuilder nomUsuario = new StringBuilder();
                nomUsuario.append(persona.getNombre().substring(0, 1))
                        .append(persona.getPaterno())
                        .append(persona.getMaterno().substring(0, 2));
                
                if (!isEdition)
                    textNomUsuario.setText(nomUsuario.toString().replace(" ", ""));

                try {
                    dateFeNacimiento.setDate(formato.parse(feNacimiento));
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
                javax.swing.JOptionPane.showMessageDialog(this, "Datos obtenidos correctamente.", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Error obteniendo los datos de RENIEC, por favor completa manualmente.", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "El DNI no es válido. Asegúrate de ingresar solo números y que la longitud sea 8.", "AVISO", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarDNIActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            pswPassword.setEchoChar((char) 0);
            pswPasswordConfirm.setEchoChar((char) 0);
        } else {
            pswPassword.setEchoChar('*');
            pswPasswordConfirm.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void setFotoInLabel(JLabel labelName, String base64Image, String root) {
        ImageIcon image = null;

        if (base64Image != null && !base64Image.isEmpty()) {
            // Eliminar el prefijo de URI de datos si está presente
            if (base64Image.startsWith("data:image")) {
                base64Image = base64Image.split(",")[1];
            }

            // Recortar espacios en blanco y reemplazar saltos de línea
            base64Image = base64Image.replaceAll("\\s", "");

            // Verificar si es necesario agregar relleno
            int padding = (4 - base64Image.length() % 4) % 4;
            base64Image = base64Image + "=".repeat(padding);

            try {
                usuarioNuevo.setFoto(base64Image);
                byte[] fotoPersona = CodificarDecoficarBase64.decodeImage(base64Image);
                image = new ImageIcon(fotoPersona);
            } catch (IllegalArgumentException e) {
                System.err.println("Error al decodificar la imagen Base64: " + e.getMessage());
                e.printStackTrace();
            }
        }

        if (image != null) {
            Icon icon = new ImageIcon(
                    image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_DEFAULT));
            labelName.setIcon(icon);
            this.repaint();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxGenero;
    private javax.swing.JComboBox<String> boxTipoUsuario;
    private javax.swing.JButton btnAgregarEditar;
    private javax.swing.JButton btnBuscarDNI;
    private javax.swing.JButton btnRegresar;
    private com.toedter.calendar.JDateChooser dateFeCreacion;
    private com.toedter.calendar.JDateChooser dateFeNacimiento;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pswPassword;
    private javax.swing.JPasswordField pswPasswordConfirm;
    private javax.swing.JTextField textCorreo;
    private javax.swing.JTextField textDni;
    private javax.swing.JLabel textIconFoto;
    private javax.swing.JTextField textMaterno;
    private javax.swing.JTextField textNomUsuario;
    private javax.swing.JTextField textPaterno;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
