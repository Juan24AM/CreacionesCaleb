package com.mycompany.creacionescaleb.test;

import com.mycompany.creacionescaleb.dao.DaoUsuario;
import com.mycompany.creacionescaleb.dao.impl.DaoUsuarioImpl;
import com.mycompany.creacionescaleb.entidades.Usuario;

/**
 *
 * @author USER
 */
public class TestDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DaoUsuario dao = new DaoUsuarioImpl();
        
        /*
        // Listar db
        for (Usuario user : dao.usuarioLista()) {
            System.out.println(user.getEdad());
        }
        */
        
        /*
        Usuario usuario = new Usuario();
      
        usuario.setDni("61292562");
        usuario.setNombres("ALVARO");
        usuario.setPaterno("MONCADA");
        usuario.setMaterno("PEREZ");
        usuario.setGenero("MASCULINO");
        usuario.setFeNacimiento("06/03/2005");
        usuario.setEdad(18);
        usuario.setFoto("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\\nCUbJRsg//9k=");
        usuario.setCorreo("amoncadape@ucvvirtual.edu.pe");
        usuario.setFeCreacion("04/12/2023");
        usuario.setDniResponsable("73186544");
        usuario.setTipoUsuario("ADMIN");
        usuario.setUsername("GG");
        usuario.setPassword("10002000");
        
        System.out.println(dao.UsuarioInsert(usuario)); 
        */
        
        
        /*
        Usuario user1 = dao.UsuarioGet(1, null);
        if (user1 != null)
            System.out.println(user1.getFoto());

        */
        
        /*
        // Login
        Usuario userLogin = dao.usuarioLogin("jportocarrerori", "10002000");
        System.out.println(dao.getMensaje());
        System.out.println(userLogin.getDni());
        System.out.println(userLogin.getUsername());
        System.out.println(userLogin.getPassword());
        */
    }
}
