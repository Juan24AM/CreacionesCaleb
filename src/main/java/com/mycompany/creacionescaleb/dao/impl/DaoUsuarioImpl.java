/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.creacionescaleb.dao.impl;

import com.mycompany.creacionescaleb.dao.DaoUsuario;
import com.mycompany.creacionescaleb.entidades.Usuario;
import com.mycompany.creacionescaleb.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class DaoUsuarioImpl implements DaoUsuario {

    private ConexionBD conexion;
    private String mensaje;

    public DaoUsuarioImpl() {
        conexion = new ConexionBD();
    }

    @Override
    public List<Usuario> usuarioLista() {
        List<Usuario> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("dni,")
                .append("nombres,")
                .append("paterno,")
                .append("materno,")
                .append("genero,")
                .append("feNacimiento,")
                .append("edad,")
                .append("foto,")
                .append("correo,")
                .append("feCreacion,")
                .append("dniResponsable,")
                .append("tipoUsuario,")
                .append("username")
                .append(" FROM usuario");
        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setDni(rs.getString(2));
                usuario.setNombres(rs.getString(3));
                usuario.setPaterno(rs.getString(4));
                usuario.setMaterno(rs.getString(5));
                usuario.setGenero(rs.getString(6));
                usuario.setFeNacimiento(rs.getString(7));
                usuario.setEdad(rs.getInt(8));
                usuario.setFoto(rs.getString(9));
                usuario.setCorreo(rs.getString(10));
                usuario.setFeCreacion(rs.getString(11));
                usuario.setDniResponsable(rs.getString(12));
                usuario.setTipoUsuario(rs.getString(13));
                usuario.setUsername(rs.getString(14));
                lista.add(usuario);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
            System.out.println(mensaje);
        }
        return lista;
    }

    @Override
    public Usuario UsuarioGet(Integer id, String dni) {
        Usuario usuario = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("dni,")
                .append("nombres,")
                .append("paterno,")
                .append("materno,")
                .append("genero,")
                .append("feNacimiento,")
                .append("edad,")
                .append("foto,")
                .append("correo,")
                .append("feCreacion,")
                .append("dniResponsable,")
                .append("tipoUsuario,")
                .append("username")
                .append(" FROM usuario");

        // Verificar si se proporciona un ID o un DNI
        if (id != null) {
            sql.append(" WHERE id = ?");
        } else if (dni != null) {
            sql.append(" WHERE dni = ?");
        } else {
            return null;
        }

        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            // Establecer el valor del parámetro según si es ID o DNI
            if (id != null) {
                ps.setInt(1, id);
            } else {
                ps.setString(1, dni);
            }
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setDni(rs.getString(2));
                usuario.setNombres(rs.getString(3));
                usuario.setPaterno(rs.getString(4));
                usuario.setMaterno(rs.getString(5));
                usuario.setGenero(rs.getString(6));
                usuario.setFeNacimiento(rs.getString(7));
                usuario.setEdad(rs.getInt(8));
                usuario.setFoto(rs.getString(9));
                usuario.setCorreo(rs.getString(10));
                usuario.setFeCreacion(rs.getString(11));
                usuario.setDniResponsable(rs.getString(12));
                usuario.setTipoUsuario(rs.getString(13));
                usuario.setUsername(rs.getString(14));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
            System.out.println(mensaje);
        }
        return usuario;
    }

    @Override
    public String UsuarioInsert(Usuario usuario) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO usuario(")
                .append("dni,") // 1
                .append("nombres,") // 2
                .append("paterno,") // 3
                .append("materno,") // 4
                .append("genero,") // 5
                .append("feNacimiento,") // 6
                .append("edad,") // 7
                .append("foto,") // 8
                .append("correo,") // 9
                .append("feCreacion,") // 10
                .append("dniResponsable,") // 11
                .append("tipoUsuario,") // 12
                .append("username") // 13
                .append(") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setString(1, usuario.getDni());
            ps.setString(2, usuario.getNombres());
            ps.setString(3, usuario.getPaterno());
            ps.setString(4, usuario.getMaterno());
            ps.setString(5, usuario.getGenero());
            ps.setString(6, usuario.getFeNacimiento());
            ps.setInt(7, usuario.getEdad());
            ps.setString(8, usuario.getFoto());
            ps.setString(9, usuario.getCorreo());
            ps.setString(10, usuario.getFeCreacion());
            ps.setString(11, usuario.getDniResponsable());
            ps.setString(12, usuario.getTipoUsuario());
            ps.setString(13, usuario.getUsername());
            int cont = ps.executeUpdate();
            mensaje = (cont == 0) ? "No se insertó" : null;
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String UsuarioUptdate(Usuario usuario) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE usuario SET ")
                .append("dni = ?,") // 1
                .append("nombres = ?,") // 2
                .append("paterno = ?,") // 3
                .append("materno = ?,") // 4
                .append("genero = ?,") // 5
                .append("feNacimiento = ?,") // 6
                .append("edad = ?,") // 7
                .append("foto = ?,") // 8
                .append("correo = ?,") // 9
                .append("feCreacion = ?,") // 10
                .append("dniResponsable = ?,") // 11
                .append("tipoUsuario = ?,") // 12
                .append("username = ?") // 13
                .append(" WHERE id = ?"); // 14
        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setString(1, usuario.getDni());
            ps.setString(2, usuario.getNombres());
            ps.setString(3, usuario.getPaterno());
            ps.setString(4, usuario.getMaterno());
            ps.setString(5, usuario.getGenero());
            ps.setString(6, usuario.getFeNacimiento());
            ps.setInt(7, usuario.getEdad());
            ps.setString(8, usuario.getFoto());
            ps.setString(9, usuario.getCorreo());
            ps.setString(10, usuario.getFeCreacion());
            ps.setString(11, usuario.getDniResponsable());
            ps.setString(12, usuario.getTipoUsuario());
            ps.setString(13, usuario.getUsername());
            ps.setInt(14, usuario.getId());
            int cont = ps.executeUpdate();
            mensaje = (cont == 0) ? "No se actualizó" : null;
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String UsuarioDelete(Integer id, String dni) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM usuario");
        // Verificar si se proporciona un ID o un DNI
        if (id != null) {
            sql.append(" WHERE id = ?");
        } else if (dni != null) {
            sql.append(" WHERE dni = ?");
        } else {
            System.out.println("Parametros invalidos en Delete!");
            return null;
        }
        
        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            // Establecer el valor del parámetro según si es ID o DNI
            if (id != null) {
                ps.setInt(1, id);
            } else {
                ps.setString(1, dni);
            }
            int cont = ps.executeUpdate();
            mensaje = (cont == 0) ? "No se eliminó" : null;
        } catch (Exception e) {
            mensaje = e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public Usuario usuarioLogin(String user, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
