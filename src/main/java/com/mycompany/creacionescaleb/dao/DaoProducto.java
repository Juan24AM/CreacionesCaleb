
package com.mycompany.creacionescaleb.dao;

import com.mycompany.creacionescaleb.entidades.Producto;
import java.util.List;

/**
 *
 * @author USER
 */
public interface DaoProducto {
    List<Producto> productoLista();
    Producto productoGet(Integer id);
    String ProductoInsert(Producto producto);
    String ProductoUptdate(Producto producto);
    String ProductoDelete(Integer id);
    String ProductoActualizarStock(Integer id, Integer cantidadVendida);
    String getMensaje();
}
