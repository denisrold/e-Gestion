package com.egestion.gestion.dao;

import com.egestion.gestion.models.Usuario;


import java.util.List;

public interface usuarioDao {
    List<Usuario> getUsuario();

    void eliminar(Long id);

    void registrar(Usuario usuario);

    boolean verificarEmailPassword(Usuario usuario);
}
