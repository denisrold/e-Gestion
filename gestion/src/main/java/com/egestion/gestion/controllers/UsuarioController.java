package com.egestion.gestion.controllers;

import com.egestion.gestion.dao.UsuarioDaoimp;
import com.egestion.gestion.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDaoimp usuarioDao;
    @RequestMapping(value = "api/usuario/{id}")
    public Usuario obtenerUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(Long.valueOf("123456"));
        usuario.setEmail("denisroldan@mail.com");
        usuario.setApellido("roldan");
        usuario.setNombre("denis");
        usuario.setPassword("123456");
        usuario.setTelefono("321321321");
        return usuario;
    }
    @RequestMapping(value = "api/allusuarios", method = RequestMethod.GET)
    public List<Usuario> obtenerUsuarios(){
       return usuarioDao.getUsuario();
    }
    @RequestMapping(value = "api/allusuarios", method = RequestMethod.POST)
    public void registrarUsuarios(@RequestBody Usuario usuario){
        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminarUsuario(@PathVariable Long id){
       usuarioDao.eliminar(id);
    }

}
