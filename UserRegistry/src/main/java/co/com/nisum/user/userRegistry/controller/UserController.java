package co.com.nisum.user.userRegistry.controller;

import co.com.nisum.user.userRegistry.utils.Constants;
import co.com.nisum.user.userRegistry.utils.exceptions.BusinessException;
import co.com.nisum.user.userRegistry.model.User;
import co.com.nisum.user.userRegistry.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/get-all", produces = "application/json")
    public ResponseEntity<List<User>> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
        } catch (BusinessException be) {
            Map<String, String> error = new HashMap<>();
            error.put(Constants.messageKey, be.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
