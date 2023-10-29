package com.egestion.gestion.controllers;

import com.egestion.gestion.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
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
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setId(Long.valueOf(123456L));
        usuario.setEmail("denisroldan@mail.com");
        usuario.setApellido("roldan");
        usuario.setNombre("denis");
        usuario.setPassword("123456");
        usuario.setTelefono("321321321");

        Usuario usuario2 = new Usuario();
        usuario2.setId(Long.valueOf(123456L));
        usuario2.setEmail("denisroldan1@mail.com");
        usuario2.setApellido("roldan1");
        usuario2.setNombre("denis1");
        usuario2.setPassword("123456");
        usuario2.setTelefono("321321321");

        Usuario usuario3 = new Usuario();
        usuario3.setId(Long.valueOf(123456L));
        usuario3.setEmail("denisroldan1@mail.com");
        usuario3.setApellido("roldan1");
        usuario3.setNombre("denis1");
        usuario3.setPassword("123456");
        usuario3.setTelefono("321321321");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        return usuarios;
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
