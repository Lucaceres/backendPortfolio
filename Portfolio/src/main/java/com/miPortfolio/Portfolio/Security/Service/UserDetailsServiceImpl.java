package com.miPortfolio.Portfolio.Security.Service;

import com.miPortfolio.Portfolio.Security.Entity.Usuario;
import com.miPortfolio.Portfolio.Security.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findUsuarioByNombreUsuario(nombreUsuario)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with nombreUsuario: " + nombreUsuario));

        return UserDetailsImpl.build(user);
    }
}
