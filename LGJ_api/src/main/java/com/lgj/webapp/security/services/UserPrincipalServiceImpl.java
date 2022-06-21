package com.lgj.webapp.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lgj.webapp.entities.User;
import com.lgj.webapp.exception.NotFoundException;
import com.lgj.webapp.repository.UserRepository;

@Service
public class UserPrincipalServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado con nombre de usuario: " + username));

        return UserPrincipal.build(user);
    }

}
