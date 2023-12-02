/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.creacionescaleb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class ConexionBD {
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String IP = "161.132.38.44";
    private String PORT = "3306";
    private String DATABASE = "creacionescaleb";
    private final String URL = String.format("jdbc:mysql://%s:%s/%s", IP, PORT, DATABASE);
    private final String USER = "proyectoucv";
    private final String PASS = "proyectoucv";
    
    public Connection getConexion() throws SQLException{
        Connection c = null;
        try {
            c = DriverManager.getConnection(URL, USER, PASS);
            Class.forName(JDBC_DRIVER);
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
        return c;
    }    
    
}
