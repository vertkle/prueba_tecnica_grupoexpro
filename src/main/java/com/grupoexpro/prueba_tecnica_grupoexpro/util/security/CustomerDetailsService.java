package com.grupoexpro.prueba_tecnica_grupoexpro.util.security;

import com.grupoexpro.prueba_tecnica_grupoexpro.model.Usuario;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.grupoexpro.prueba_tecnica_grupoexpro.util.Constantes.*;

@Service
public class CustomerDetailsService implements UserDetailsService {

    private Usuario usuario;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        usuario = new Usuario(USER_PRUEBA,PASSWORD_PRUEBA, NOMBRE_USER_PRUEBA);
        return new User(USER_PRUEBA, PASSWORD_PRUEBA, new ArrayList<>());
    }

    public Usuario getUserDetail(){
        return usuario;
    }
}
