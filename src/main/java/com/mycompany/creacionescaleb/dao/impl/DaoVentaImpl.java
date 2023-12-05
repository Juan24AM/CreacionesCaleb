/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.creacionescaleb.dao.impl;

import com.mycompany.creacionescaleb.dao.DaoVenta;
import com.mycompany.creacionescaleb.entidades.Venta;
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
public class DaoVentaImpl implements DaoVenta {

    private ConexionBD conexion;
    private String mensaje;

    public DaoVentaImpl() {
        conexion = new ConexionBD();
    }

    @Override
    public List<Venta> VentaLista() {
        List<Venta> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idVenta,")
                .append("fecha,")
                .append("dni,")
                .append("nombre,")
                .append("telefono,")
                .append("metodoPago,")
                .append("descripcion,")
                .append("cantidad,")
                .append("precio,")
                .append("total")
                .append(" FROM venta");
        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(rs.getInt(1));
                venta.setFecha(rs.getString(2));
                venta.setDni(rs.getString(3));
                venta.setNombre(rs.getString(4));
                venta.setTelefono(rs.getString(5));
                venta.setMetodoPago(rs.getString(6));
                venta.setDescripcion(rs.getString(7));
                venta.setCantidad(rs.getInt(8));
                venta.setPrecio(rs.getDouble(9));
                venta.setTotal(rs.getDouble(10));
                lista.add(venta);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
            System.out.println(mensaje);
        }
        return lista;
    }

    @Override
    public Venta ventaGet(Integer id) {
        Venta venta = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idVenta,")
                .append("fecha,")
                .append("dni,")
                .append("nombre,")
                .append("telefono,")
                .append("metodoPago,")
                .append("descripcion,")
                .append("cantidad,")
                .append("precio,")
                .append("total")
                .append(" FROM venta")
                .append(" WHERE idVenta = ?");
        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                venta = new Venta();
                venta.setIdVenta(rs.getInt(1));
                venta.setFecha(rs.getString(2));
                venta.setDni(rs.getString(3));
                venta.setNombre(rs.getString(4));
                venta.setTelefono(rs.getString(5));
                venta.setMetodoPago(rs.getString(6));
                venta.setDescripcion(rs.getString(7));
                venta.setCantidad(rs.getInt(8));
                venta.setPrecio(rs.getDouble(9));
                venta.setTotal(rs.getDouble(10));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
            System.out.println(mensaje);
        }
        return venta;
    }

    @Override
    public String VentaInsert(Venta venta) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO venta(")
                .append("fecha,")
                .append("dni,")
                .append("nombre,")
                .append("telefono,")
                .append("metodoPago,")
                .append("descripcion,")
                .append("cantidad,")
                .append("precio,")
                .append("total")
                .append(") VALUES (?,?,?,?,?,?,?,?,?)");
        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setString(1, venta.getFecha());
            ps.setString(2, venta.getDni());
            ps.setString(3, venta.getNombre());
            ps.setString(4, venta.getTelefono());
            ps.setString(5, venta.getMetodoPago());
            ps.setString(6, venta.getDescripcion());
            ps.setInt(7, venta.getCantidad());
            ps.setDouble(8, venta.getPrecio());
            ps.setDouble(9, venta.getTotal());
            int cont = ps.executeUpdate();
            mensaje = (cont == 0) ? "No se insertó" : null;
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String VentaUptdate(Venta venta) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE venta SET ")
                .append("fecha = ?,")
                .append("dni = ?,")
                .append("nombre = ?,")
                .append("telefono = ?,")
                .append("metodoPago = ?,")
                .append("descripcion = ?,")
                .append("cantidad = ?,")
                .append("precio = ?,")
                .append("total = ? ")
                .append("WHERE idVenta = ?");  // 1
        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setString(1, venta.getFecha());
            ps.setString(2, venta.getDni());
            ps.setString(3, venta.getNombre());
            ps.setString(4, venta.getTelefono());
            ps.setString(5, venta.getMetodoPago());
            ps.setString(6, venta.getDescripcion());
            ps.setInt(7, venta.getCantidad());
            ps.setDouble(8, venta.getPrecio());
            ps.setDouble(9, venta.getTotal());
            ps.setInt(10, venta.getIdVenta());
            int cont = ps.executeUpdate();
            mensaje = (cont == 0) ? "No se actualizó" : null;
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String VentaDelete(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM usuario");
        sql.append(" WHERE id = ?");
        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setInt(1, id);
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

}
