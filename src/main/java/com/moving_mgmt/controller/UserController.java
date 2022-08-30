package com.moving_mgmt.controller;
import com.moving_mgmt.utils.JwtAuthentication;
import com.moving_mgmt.model.User;
import com.moving_mgmt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    UserRepository repository;

    // get user by username
    @GetMapping("/api/users/{username}")
    public User findByUsername(@PathVariable String username) throws Exception {
        return repository.findByUsername(username);
    }

    // signup
    @PostMapping("/api/signup")
    public User signup(@RequestBody User user) { // @RequestBody annotation—which will map the body of this request to a transfer object, then deserialize the body onto a Java object for easier use
        // Hash password
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        // set auth token
        user.setToken(JwtAuthentication.createJWT(user.getUsername(), user.getEmail(), "user_signup", 2));
        repository.save(user);
        return user;
    }

    // login
    @PostMapping("/api/login")
    public User login(@RequestBody User user) throws Exception {
            User loginUser = repository.findByEmail(user.getEmail());
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if(encoder.matches(user.getPassword(), loginUser.getPassword()) && !loginUser.equals(null)) {
                // set auth token
                loginUser.setToken(JwtAuthentication.createJWT(user.getUsername(), user.getEmail(), "user_signup", 2));
                repository.save(loginUser);
            } else {
                throw new IllegalAccessException("invalid credentials");
            }
            return loginUser;
    }

    // update user
    @PutMapping("/api/users/{username}")
    public User updatedUser(@PathVariable String username, @RequestBody User user, HttpServletRequest request) throws Exception { // @PathVariable will allow us to enter the int id into the request URI as a parameter
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(!JwtAuthentication.decodeJWT(token).equals(IllegalArgumentException.class)) {
            User tempUser = repository.findByUsername(username);

            if (!tempUser.equals(null)) {
                user.setId(tempUser.getId());
                repository.save(user);
            }
            return user;
        }
        throw new IllegalAccessException("invalid token");
    }

    // remove user
    @DeleteMapping("/api/users/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void deleteUser(@PathVariable String username, HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(!JwtAuthentication.decodeJWT(token).equals(IllegalArgumentException.class)) {
            repository.deleteByUsername(username);
        }
    }
}
