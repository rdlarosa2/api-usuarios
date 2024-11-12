package com.users.api.controllers;

import com.users.api.dto.UserEntityDto;
import com.users.api.dto.UserEntityResponseDto;
import com.users.api.exceptions.CreatingUserWithExistentEmailException;
import com.users.api.exceptions.CreatingUserWithIncorrectEmailSyntax;
import com.users.api.exceptions.UserErrorResponse;
import com.users.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService) {
        this.userService = theUserService;
    }

    @GetMapping("/users")
    public List<UserEntityResponseDto> findAll() {
        return userService.findAll();
    }

    @PostMapping("/users")
    public UserEntityResponseDto save(@RequestBody UserEntityDto theUser) {
        UserEntityResponseDto userEntityDto = null;

        if ( !validateEmail(theUser.getEmail()) ) {
            throw new CreatingUserWithIncorrectEmailSyntax("El email no tiene el formato correcto.");
        }

        userEntityDto = userService.save(theUser);

        return userEntityDto;
    }

    private boolean validateEmail(String email) {
        String regularExp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$" ;

        Pattern p = Pattern.compile(regularExp);
        Matcher m = p.matcher(email);
        boolean unifica = m.matches();
        return unifica;
    }

    @GetMapping("/users/{id}")
    public UserEntityResponseDto findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @GetMapping("/users/name={name}")
    public List<UserEntityResponseDto> findByName(@PathVariable String name) {
        return userService.findByName(name);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(CreatingUserWithExistentEmailException exc) {
        UserErrorResponse error = new UserErrorResponse(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    //
    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(CreatingUserWithIncorrectEmailSyntax exc) {
        UserErrorResponse error = new UserErrorResponse(exc.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
