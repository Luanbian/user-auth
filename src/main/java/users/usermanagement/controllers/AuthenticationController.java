package users.usermanagement.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import users.usermanagement.domain.dtos.AuthDto;
import users.usermanagement.domain.dtos.LoginResponseDto;
import users.usermanagement.domain.dtos.RegisterDto;
import users.usermanagement.infra.repository.UserRepository;
import users.usermanagement.infra.security.TokenService;
import users.usermanagement.main.entities.User;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody @Valid AuthDto data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDto data) {
        var alreadyExist = this.repository.findByLogin(data.login());
        if(alreadyExist != null) {
            return ResponseEntity.badRequest().build();
        } else {
            String encrypterPassword = new BCryptPasswordEncoder().encode(data.password());
            User newUser = new User(data.login(), encrypterPassword, data.role());
            this.repository.save(newUser);
            return ResponseEntity.ok().build();
        }
    }
}
