/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.creacionescaleb.test;

import com.mycompany.creacionescaleb.util.ConexionBD;

/**
 *
 * @author USER
 */
public class TestDBConeccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ConexionBD con = new ConexionBD();
            con.getConexion();
            System.out.println("Exito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
