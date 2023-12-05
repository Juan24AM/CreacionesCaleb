package com.mycompany.creacionescaleb.dao.impl;

import com.mycompany.creacionescaleb.dao.DaoProducto;
import com.mycompany.creacionescaleb.entidades.Producto;
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
public class DaoProductoImpl implements DaoProducto {

    private ConexionBD conexion;
    private String mensaje;

    public DaoProductoImpl() {
        conexion = new ConexionBD();
    }

    @Override
    public List<Producto> productoLista() {
        List<Producto> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("nombre,")
                .append("descripcion,")
                .append("precio,")
                .append("stock,")
                .append("genero,")
                .append("tipo,")
                .append("fotoProducto,")
                .append("fechaIngreso")
                .append(" FROM producto");
        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setDescripcion(rs.getString(3));
                producto.setPrecio(rs.getDouble(4));
                producto.setStock(rs.getInt(5));
                producto.setGenero(rs.getString(7));
                producto.setTipo(rs.getString(7));
                producto.setFotoProducto(rs.getString(8));
                producto.setFechaIngreso(rs.getString(9));
                lista.add(producto);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
            System.out.println(mensaje);
        }
        return lista;
    }

    @Override
    public Producto productoGet(Integer id) {
        Producto producto = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("nombre,")
                .append("descripcion,")
                .append("precio,")
                .append("stock,")
                .append("genero,")
                .append("tipo,")
                .append("fotoProducto,")
                .append("fechaIngreso")
                .append(" FROM producto")
                .append(" WHERE id = ?");
        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setId(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setDescripcion(rs.getString(3));
                producto.setPrecio(rs.getDouble(4));
                producto.setStock(rs.getInt(5));
                producto.setGenero(rs.getString(6));
                producto.setTipo(rs.getString(7));
                producto.setFotoProducto(rs.getString(8));
                producto.setFechaIngreso(rs.getString(9));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
            System.out.println(mensaje);
        }
        return producto;
    }

    @Override
    public String ProductoInsert(Producto producto) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO producto(")
                .append("nombre,")
                .append("descripcion,")
                .append("precio,")
                .append("stock,")
                .append("genero,")
                .append("tipo,")
                .append("fotoProducto,")
                .append("fechaIngreso")
                .append(") VALUES (?,?,?,?,?,?,?,?)");
        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setString(5, producto.getGenero());
            ps.setString(6, producto.getTipo());
            ps.setString(7, producto.getFotoProducto());
            ps.setString(8, producto.getFechaIngreso());
            int cont = ps.executeUpdate();
            mensaje = (cont == 0) ? "No se insertó" : null;
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String ProductoUptdate(Producto producto) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE producto SET ")
                .append("nombre = ?,") // 1
                .append("descripcion = ?,") // 2
                .append("precio = ?,") // 3
                .append("stock = ?,") // 4
                .append("genero = ?,") // 4
                .append("tipo = ?,") // 5
                .append("fotoProducto = ?,") // 6
                .append("fechaIngreso = ?") // 7
                .append(" WHERE id = ?");
        try (Connection c = conexion.getConexion()) {
            PreparedStatement ps = c.prepareStatement(sql.toString());
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setString(5, producto.getGenero());
            ps.setString(6, producto.getTipo());
            ps.setString(7, producto.getFotoProducto());
            ps.setString(8, producto.getFechaIngreso());
            ps.setInt(9, producto.getId());
            int cont = ps.executeUpdate();
            mensaje = (cont == 0) ? "No se actualizó" : null;
        } catch (Exception e) {
            mensaje = e.getMessage();
            System.out.println(mensaje);
        }
        return mensaje;
    }

    @Override
    public String ProductoDelete(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM producto");
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
