package com.mycompany.creacionescaleb.entidades;

/**
 *
 * @author USER
 */
public abstract class Persona {
    protected Integer id;
    protected String dni;
    protected String nombres;
    protected String paterno;
    protected String materno;
    protected String genero;
    protected String feNacimiento;
    protected int edad;
    protected String foto; // Foto en base64
    protected String correo;
}