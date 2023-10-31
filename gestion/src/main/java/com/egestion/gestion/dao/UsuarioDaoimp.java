package com.egestion.gestion.dao;

import com.egestion.gestion.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoimp implements usuarioDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Usuario> getUsuario() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public void eliminar(Long id){
    Usuario usuario = entityManager.find(Usuario.class,id);
    entityManager.remove(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
    entityManager.merge(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorEmailPassword(Usuario usuario) {
        String query = "FROM Usuario WHERE email=:email";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if(lista.isEmpty()){return null;}
        //configuration
        int saltLength = 16;
        int hashLength = 20;
        int parallelism = 2;
        int memory = 1024;
        int iterations = 2;
        Argon2PasswordEncoder argon2 = new Argon2PasswordEncoder(saltLength, hashLength, parallelism, memory, iterations);
        String hashedPassword = lista.get(0).getPassword();
        String password = usuario.getPassword();
        if(argon2.matches(password,hashedPassword)){
            return lista.get(0);
        }
        return null;
    }

}
