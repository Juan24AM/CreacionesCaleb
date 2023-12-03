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
      
        usuario.setDni("73186544");
        usuario.setNombres("JUAN MANUEL");
        usuario.setPaterno("PORTOCARRERO");
        usuario.setMaterno("RIVA");
        usuario.setGenero("MASCULINO");
        usuario.setFeNacimiento("24/06/2005");
        usuario.setEdad(18);
        usuario.setFoto("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");
        usuario.setCorreo("juanportocarreroriva@gmail.com");
        usuario.setFeCreacion("02/12/2023");
        usuario.setDniResponsable("73186544");
        usuario.setTipoUsuario("ADMIN");
        usuario.setUsername("JPORTOCARRERORI");
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
