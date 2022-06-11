package com.lgj.webapp.services;
import java.util.Date;
import java.util.List;

import com.lgj.webapp.dto.LoginRequestDto;
import com.lgj.webapp.dto.LoginResponseDto;
// import com.lgj.webapp.entities.Inscripcion;
import com.lgj.webapp.entities.User;
import com.lgj.webapp.exception.GeneralServiceException;
import com.lgj.webapp.exception.IncorrectRequestException;
import com.lgj.webapp.exception.NotFoundException;
import com.lgj.webapp.repository.UserRepository;
import com.lgj.webapp.util.RolSelection;
import com.lgj.webapp.util.UserConverter;
import com.lgj.webapp.util.UserValidator;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Value("${jwt.password}")
    private String jwtSecret;

    private final UserRepository userRepository;

    private final UserConverter userConverter;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserConverter userConverter, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.passwordEncoder = passwordEncoder;
    }

  
    public User findById(Long id) {
        return userRepository.findByid(id);
    }
    @Transactional
    public User createUser(User user) {
        try {
            UserValidator.validate(user);
            User existUser=userRepository.findByUsername(user.getUsername())
                    .orElse(null);
            if(existUser!=null)
                throw new IncorrectRequestException("El nombre usuario ya existe");

            String encoder=passwordEncoder.encode(user.getPassword());
            user.setPassword(encoder);

            return userRepository.save(user);
        } catch (IncorrectRequestException | NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }
    public User updateUser(User user){
        return userRepository.save(user);
    }
    public List<User> getParticipantsByRol(RolSelection rol) {
        return userRepository.findParticipantsByRol(rol);
    }
    @Transactional(readOnly = true)
    public List<User> findByPartOfFullName(String text) {
      List<User> users = userRepository.findByNamesOrLastNames(text);
      return users;
    }

    public LoginResponseDto login(LoginRequestDto request){
        try {
            User user=userRepository.findByUsername(request.getUsername())
                    .orElseThrow(()->new IncorrectRequestException("Usuario o password incorrecto"));

            if(!passwordEncoder.matches(request.getPassword(),user.getPassword()))
                throw new IncorrectRequestException("Usuario o password incorrectos");

            String token =createToken(user);

            return new LoginResponseDto(userConverter.convertEntityToDto(user),token);

        } catch (IncorrectRequestException | NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }
    
    public String createToken(User user){
        Date now =new Date();
        Date expiryDate=new Date(now.getTime()+ (1000*60*60*24));

        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512,jwtSecret).compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }catch (UnsupportedJwtException e) {
            //log.error("JWT in a particular format/configuration that does not match the format expected");
        }catch (MalformedJwtException e) {
            //log.error(" JWT was not correctly constructed and should be rejected");
        }catch (SignatureException e) {
            //log.error("Signature or verifying an existing signature of a JWT failed");
        }catch (ExpiredJwtException e) {
            //log.error("JWT was accepted after it expired and must be rejected");
        }
        return false;
    }

    public String getUsernameFromToken(String jwt) {
        try {
            return Jwts.parser().setSigningKey(jwtSecret)
                    .parseClaimsJws(jwt)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            throw new IncorrectRequestException("Invalid Token");
        }
    }
}
