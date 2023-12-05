/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.creacionescaleb.util;

import java.util.Base64;

/**
 *
 * @author USER
 */
public class CodificarDecoficarBase64 {
    // Codificar imagen a base64
    public static String encodeImage(byte[] image) {
        return Base64.getEncoder().encodeToString(image);
    }
    
    // Decodificar base64 a imagen
    public static byte[] decodeImage(String imageString) {
        return Base64.getDecoder().decode(imageString);
    }
}