package com.moving_mgmt.controller;
import com.moving_mgmt.model.Apartment;
import com.moving_mgmt.model.User;
import com.moving_mgmt.repositories.UserRepository;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository repository;

    // get user by username
    @GetMapping("/api/users/{username}")
    public User findByUsername(@PathVariable String username) throws Exception {
        return repository.findByUsername(username);
    }

    // create user
    @PostMapping("/api/users")
    public User addUser(@RequestBody User user) { // @RequestBody annotation—which will map the body of this request to a transfer object, then deserialize the body onto a Java object for easier use
        // Hash password
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        repository.save(user);
        return user;
    }

    // update user
    @PutMapping("/api/users/{username}")
    public User updatedUser(@PathVariable String username, @RequestBody User user) throws Exception { // @PathVariable will allow us to enter the int id into the request URI as a parameter
        User tempUser = repository.findByUsername(username);

        if (!tempUser.equals(null)) {
            user.setId(tempUser.getId());
            repository.save(user);
        }
        return user;
    }

    // remove user
    @DeleteMapping("/api/users/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void deleteUser(@PathVariable String username) {
        repository.deleteByUsername(username);
    }
}
