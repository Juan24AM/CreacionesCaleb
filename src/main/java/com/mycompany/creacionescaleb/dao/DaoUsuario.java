package com.mycompany.creacionescaleb.dao;

import com.mycompany.creacionescaleb.entidades.Usuario;
import java.util.List;

/**
 *
 * @author USER
 */
public interface DaoUsuario {
    List<Usuario> usuarioLista();
    Usuario UsuarioGet(Integer id, String dni);
    String UsuarioInsert(Usuario usuario);
    String UsuarioUptdate(Usuario usuario);
    String UsuarioDelete(Integer id, String dni);
    String getMensaje();
    Usuario usuarioLogin(String user, String pass);
}