/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.creacionescaleb.dao;

import com.mycompany.creacionescaleb.entidades.Venta;
import java.util.List;

/**
 *
 * @author USER
 */
public interface DaoVenta {
    List <Venta> VentaLista();
    Venta ventaGet(Integer id);
    String VentaInsert(Venta venta);
    String VentaUptdate(Venta venta);
    String VentaDelete(Integer id);
    String getMensaje();
}
