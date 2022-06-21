package com.lgj.webapp.services;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lgj.webapp.dto.LoginRequestDto;
import com.lgj.webapp.dto.LoginResponseDto;
import com.lgj.webapp.dto.SignupRequestDto;
import com.lgj.webapp.entities.Role;
// import com.lgj.webapp.entities.Inscripcion;
import com.lgj.webapp.entities.User;
import com.lgj.webapp.exception.GeneralServiceException;
import com.lgj.webapp.exception.IncorrectRequestException;
import com.lgj.webapp.exception.NotFoundException;
import com.lgj.webapp.repository.RoleRepository;
import com.lgj.webapp.repository.UserRepository;
import com.lgj.webapp.security.jwt.JwtUtils;
import com.lgj.webapp.security.services.UserPrincipal;
import com.lgj.webapp.util.RolSelection;
import com.lgj.webapp.util.UserConverter;
import com.lgj.webapp.util.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

import java.util.stream.Collectors;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    AuthenticationManager authenticationManager;

    private final UserConverter userConverter;


    public UserService(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

  
    public User findById(Long id) {
        return userRepository.findByid(id);
    }
    
    public User updateUser(User user){
        return userRepository.save(user);
    }
    
   /*  public List<User> getParticipantsByRol(RolSelection rol) {
        return userRepository.findParticipantsByRol(rol);
    }*/
    @Transactional
    public User registerUser(SignupRequestDto signupRequestDto) {
        if (userRepository.existsByUsername(signupRequestDto.getUsername())) {
            throw new IncorrectRequestException("El nombre usuario ya existe");
        }

        if (userRepository.existsByEmail(signupRequestDto.getEmail())) {
            throw new IncorrectRequestException("El email del usuario ya existe");
        }

        // Create new user's account
        User user = new User(signupRequestDto.getUsername(),
                signupRequestDto.getEmail(),
                encoder.encode(signupRequestDto.getPassword()),
                signupRequestDto.getNombres(), 
                signupRequestDto.getApellidos(),
                signupRequestDto.getTelefono(),
                signupRequestDto.getDni(),
                signupRequestDto.getNacimiento(),
                signupRequestDto.getDistrito(),
                signupRequestDto.getGenero());

        Set<String> strRoles = signupRequestDto.getRole();
        Set<Role> roles = new HashSet<>();


        if (strRoles == null) {
            Role userRole = roleRepository.findByName(RolSelection.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: No se encuentra el rol."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "participante":
                        Role participanteRole = roleRepository.findByName(RolSelection.ROLE_PARTICIPANTE)
                                .orElseThrow(() -> new RuntimeException("Error: No se encuentra el rol."));
                        roles.add(participanteRole);

                        break;
                    case "organizador":
                        Role orgRole = roleRepository.findByName(RolSelection.ROLE_ORGANIZADOR)
                                .orElseThrow(() -> new RuntimeException("Error: No se encuentra el rol"));
                            roles.add(orgRole);
                        break;
                    case "mentor":
                        Role mentRole = roleRepository.findByName(RolSelection.ROLE_MENTOR)
                            .orElseThrow(() -> new RuntimeException("Error: No se encuentra el rol"));
                        roles.add(mentRole);
            break;
                    default:
                        Role userRole = roleRepository.findByName(RolSelection.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: No se encuentra el rol."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        return userRepository.save(user);
    }
    
    @Transactional(readOnly = true)
    public List<User> findByPartOfFullName(String text) {
      List<User> users = userRepository.findByNamesOrLastNames(text);
      return users;
    }

    public LoginResponseDto authenticateUser(LoginRequestDto request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return new LoginResponseDto(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles);
    }
    
}
