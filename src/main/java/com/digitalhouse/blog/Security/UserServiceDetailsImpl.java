package com.digitalhouse.blog.Security;

import com.digitalhouse.blog.Model.Usuario;
import com.digitalhouse.blog.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service //annotation que indica tratar-se d eum serviço
public class UserServiceDetailsImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        Optional<Usuario> user = userRepository.findByUsuario(userName);
        user.orElseThrow(() -> new UsernameNotFoundException(userName + "not found."));

        return user.map(UserDetailsImpl::new).get();
    }

}
