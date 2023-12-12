package com.mycompany.creacionescaleb.test;

import com.mycompany.creacionescaleb.dao.DaoUsuario;
import com.mycompany.creacionescaleb.dao.impl.DaoUsuarioImpl;
import com.mycompany.creacionescaleb.entidades.Usuario;
import com.mycompany.creacionescaleb.util.ApiReniec;

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
        Usuario usuario = new Usuario();

        ApiReniec infoPersona = new ApiReniec("61292562", true);
        usuario.setDni(infoPersona.getDni());
        usuario.setNombres(infoPersona.getNombre());
        usuario.setPaterno(infoPersona.getPaterno());
        usuario.setMaterno(infoPersona.getMaterno());
        usuario.setGenero(infoPersona.getGenero());
        usuario.setFeNacimiento(infoPersona.getFeNacimiento());
        usuario.setEdad(infoPersona.getEdad());
        usuario.setFoto(infoPersona.getFotoPersona());
        usuario.setCorreo("amoncada@ucvvirtual.edu.pe");
        usuario.setFeCreacion("05/12/2023");
        usuario.setDniResponsable("73186544");
        usuario.setTipoUsuario("ADMIN");
        usuario.setUsername("remix");
        usuario.setPassword("10002000");

        System.out.println(dao.UsuarioInsert(usuario));

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
