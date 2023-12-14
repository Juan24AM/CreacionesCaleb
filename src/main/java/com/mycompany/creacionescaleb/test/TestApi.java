/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.creacionescaleb.test;

import com.mycompany.creacionescaleb.util.ApiReniec;

/**
 *
 * @author USER
 */
public class TestApi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApiReniec infoPersona = new ApiReniec("44444444");
        System.out.println(infoPersona.getNombre());
        System.out.println(infoPersona.getFotoPersona());
    }
    
}
