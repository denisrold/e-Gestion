package com.egestion.gestion.controllers;

import com.egestion.gestion.dao.UsuarioDaoimp;
import com.egestion.gestion.models.Usuario;
import com.egestion.gestion.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDaoimp usuarioDao;
    @Autowired
    private JWTutil jwtutil;
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
    public List<Usuario> obtenerUsuarios(@RequestHeader(value="Authorization") String token){

    String usuarioId = jwtutil.getKey(token);

    if(usuarioId == null){
        return new ArrayList<>();
    }
       return usuarioDao.getUsuario();
    }
    @RequestMapping(value = "api/regusuarios", method = RequestMethod.POST)
    public void registrarUsuarios(@RequestBody Usuario usuario){
        //configuration
        int saltLength = 16;
        int hashLength = 20;
        int parallelism = 2;
        int memory = 1024;
        int iterations = 2;

        Argon2PasswordEncoder argon2 = new Argon2PasswordEncoder(saltLength, hashLength, parallelism, memory, iterations);
        String hashedPassword = argon2.encode(usuario.getPassword());
        usuario.setPassword(hashedPassword);
        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminarUsuario(@PathVariable Long id){
       usuarioDao.eliminar(id);
    }

}
