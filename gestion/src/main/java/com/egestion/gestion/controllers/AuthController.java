package com.egestion.gestion.controllers;

import com.egestion.gestion.dao.UsuarioDaoimp;

import com.egestion.gestion.models.Usuario;
import com.egestion.gestion.utils.JWTutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDaoimp usuarioDao;

    @Autowired
    private JWTutil jwtutil;
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        Usuario logguedUser = usuarioDao.obtenerUsuarioPorEmailPassword(usuario);
        if(logguedUser != null){
           String token = jwtutil.create(String.valueOf(logguedUser.getId()),String.valueOf(logguedUser.getEmail()));
            return token;
        }
        return "FAIL";
    }
}
