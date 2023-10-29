package com.egestion.gestion.controllers;

import com.egestion.gestion.dao.UsuarioDaoimp;
import com.egestion.gestion.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDaoimp usuarioDao;
    @RequestMapping(value = "usuario/{id}")
    public Usuario obtenerUsuario(@PathVariable String id){
        Usuario usuario = new Usuario();
        usuario.setId(Long.valueOf("123456"));
        usuario.setEmail("denisroldan@mail.com");
        usuario.setApellido("roldan");
        usuario.setNombre("denis");
        usuario.setPassword("123456");
        usuario.setTelefono("321321321");
        return usuario;
    }
    @RequestMapping(value = "usuarios")
    public List<Usuario> obtenerUsuarios(){
       return usuarioDao.getUsuario();
    }
    @RequestMapping(value = "usuarios1")
    public Usuario editarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setEmail("denisroldan@mail.com");
        usuario.setApellido("roldan");
        usuario.setNombre("denis");
        usuario.setPassword("123456");
        usuario.setTelefono("321321321");
        return usuario;
    }
    @RequestMapping(value = "usuarios2")
    public Usuario eliminarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setEmail("denisroldan@mail.com");
        usuario.setApellido("roldan");
        usuario.setNombre("denis");
        usuario.setPassword("123456");
        usuario.setTelefono("321321321");
        return usuario;
    }

    @RequestMapping(value = "usuarios3")
    public Usuario buscarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setEmail("denisroldan@mail.com");
        usuario.setApellido("roldan");
        usuario.setNombre("denis");
        usuario.setPassword("123456");
        usuario.setTelefono("321321321");
        return usuario;
    }
}
