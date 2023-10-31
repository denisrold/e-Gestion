package com.egestion.gestion.controllers;

import com.egestion.gestion.dao.UsuarioDaoimp;

import com.egestion.gestion.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDaoimp usuarioDao;
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        if(usuarioDao.verificarEmailPassword(usuario)){

            return "Ok";
        }
        return "Incorrect password";
    }
}
