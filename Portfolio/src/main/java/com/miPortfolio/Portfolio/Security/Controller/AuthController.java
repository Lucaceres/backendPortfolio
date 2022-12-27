package com.miPortfolio.Portfolio.Security.Controller;

import com.miPortfolio.Portfolio.Controller.Mensaje;
import com.miPortfolio.Portfolio.Security.Entity.Rol;
import com.miPortfolio.Portfolio.Security.Entity.Roles;
import com.miPortfolio.Portfolio.Security.Entity.Usuario;
import com.miPortfolio.Portfolio.Security.Jwt.JwtUtils;
import com.miPortfolio.Portfolio.Security.Payload.request.LoginRequest;
import com.miPortfolio.Portfolio.Security.Payload.request.SignupRequest;
import com.miPortfolio.Portfolio.Security.Payload.response.UsuarioInfoResponse;
import com.miPortfolio.Portfolio.Security.Repository.RolRepository;
import com.miPortfolio.Portfolio.Security.Repository.UsuarioRepository;
import com.miPortfolio.Portfolio.Security.Service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/auth")
//@CrossOrigin(origins = "https://frontendap-222a1.web.app/")

public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getNombreUsuario(), loginRequest.getPassUsuario()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities()
                .stream().map(item -> item.getAuthority()).collect(Collectors.toList());
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UsuarioInfoResponse(userDetails.getId(),
                        userDetails.getUsername(),
                        roles,jwtCookie.toString()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        //VALIDACIONES
        if (usuarioRepository.existsUsuarioByNombreUsuario(signupRequest.getNombreUsuario())) {
            return ResponseEntity.badRequest().body(new Mensaje("Error: username already taken"));
        }

        //CREO NUEVO USUARIO

        Usuario usuario = new Usuario(signupRequest.getNombreUsuario()
                , passwordEncoder.encode(signupRequest.getPassUsuario()));
        Set<String> strRoles = signupRequest.getRoles();
        Set<Rol> roles = new HashSet<>();



        if (strRoles == null) {
            Rol rolUsuario = rolRepository.findByNombreRol(Roles.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Rol no ecncontrado123"));
            roles.add(rolUsuario);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Rol adminRol = rolRepository.findByNombreRol(Roles.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no ecncontrado1"));
                        roles.add(adminRol);
                        break;

                    default:
                        Rol usuarioRol = rolRepository.findByNombreRol(Roles.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Rol no ecncontrado"));
                        roles.add(usuarioRol);
                }
            });
        }
        usuario.setRoles(roles);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(new Mensaje("Usuario registrado con exito!"));
    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new Mensaje("Sesion cerrada!"));
    }



}
