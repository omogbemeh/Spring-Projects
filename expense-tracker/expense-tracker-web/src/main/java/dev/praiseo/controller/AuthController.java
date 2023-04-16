package dev.praiseo.controller;

import dev.praiseo.model.User;
import dev.praiseo.security.LoginUserRegisterBody;
import dev.praiseo.security.RegisterUserRequestBody;
import dev.praiseo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/auth")
public class AuthController {
    private static Logger log = LoggerFactory.getLogger(AuthController.class);
    private final UserService userService;
    private final PasswordEncoder encoder;

    public AuthController(UserService userService, PasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @PostMapping(value = "/register", produces = "application/json")
    public ResponseEntity<User> registerUser(@RequestBody RegisterUserRequestBody registerBody) {
        User user = userService.saveUser(registerBody.toUser(encoder));
        log.info(registerBody.toString());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public void loginUser(@RequestBody LoginUserRegisterBody loginBody) {

    }
}
