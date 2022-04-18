package com.ey.users.controller;

import com.ey.users.domain.PersonalData;
import com.ey.users.domain.SessionData;
import com.ey.users.repositories.SessionRepository;
import com.ey.users.repositories.UserRepository;
import com.ey.users.utilities.Helper;
import com.ey.users.utilities.ResponseHandler;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.ey.users.utilities.Constants.*;
import static com.ey.users.utilities.Messages.*;
import static com.ey.users.utilities.Validator.isValidEmail;
import static com.ey.users.utilities.Validator.isValidPassword;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController extends Helper {

    @Autowired
    UserRepository userRepository;

    @Autowired
    SessionRepository sessionRepository;

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers() {
        try {
            List<PersonalData> users = new ArrayList<PersonalData>();
            userRepository.findAll().forEach(users::add);
            if (users.isEmpty())
                return ResponseHandler.generateResponse(NO_USERS, HttpStatus.NO_CONTENT, users);
            return ResponseHandler.generateResponse(SUCCESSFUL, HttpStatus.OK, users);
        } catch (Exception exception) {
            return ResponseHandler.generateResponse(INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @GetMapping("/users/{email}")
    public ResponseEntity<Object> getUserByEmail(@PathVariable String email){
        try {
            Optional<PersonalData> personalData = userRepository.findByEmail(email);
            if(personalData.isPresent())
                return ResponseHandler.generateResponse(USER_FOUND_SUCCESSFULLY, HttpStatus.OK, personalData.get());
            return ResponseHandler.generateResponse(EMAIL_NOT_FOUND, HttpStatus.NOT_FOUND, email);
        } catch (Exception exception) {
            return ResponseHandler.generateResponse(INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody PersonalData personalData){
        try {
            if(!isValidPassword(personalData.getPassword()) || !isValidEmail(personalData.getEmail()))
                return ResponseHandler.generateResponse(EMAIL_OR_PASSWORD_WRONG, HttpStatus.BAD_REQUEST, personalData);
            Optional<PersonalData> email = userRepository.findByEmail(personalData.getEmail());
            if(email.isPresent())
                return ResponseHandler.generateResponse(EMAIL_ALREADY_IN_USE, HttpStatus.IM_USED, personalData);

            SessionData sessionData =  sessionRepository.save(new SessionData(personalData.getEmail()));
            PersonalData pd = userRepository.save(new PersonalData(personalData.getName(), personalData.getEmail(), personalData.getPassword(), personalData.getPhones(), sessionData));

            return ResponseHandler.generateResponse(USER_CREATED_SUCCESSFULLY, HttpStatus.CREATED, pd);
        } catch (Exception exception) {
            return ResponseHandler.generateResponse(INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @PostMapping("/token")
    public ResponseEntity<Object> login(@RequestParam("email") String email, @RequestParam("password") String password) {
        try{
            Optional<PersonalData> optionalPersonalData = userRepository.findByEmailAndPassword(email, password);
            if(!optionalPersonalData.isPresent())
                return ResponseHandler.generateResponse(EMAIL_OR_PASSWORD_WRONG, HttpStatus.BAD_REQUEST, EMPTY);
            String token = getJWTToken(email);
            optionalPersonalData.get().getSessionData().setToken(token);
            userRepository.save(optionalPersonalData.get());
            return ResponseHandler.generateResponse(TOKEN_GENERATED_SUCCESSFULLY, HttpStatus.OK, optionalPersonalData.get());
        } catch (Exception exception) {
            return ResponseHandler.generateResponse(INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        }
    }

    @GetMapping("/error")
    public ResponseEntity<Object> error() {
        return ResponseHandler.generateResponse(UNEXPECTED_ERROR, HttpStatus.BAD_REQUEST, UNEXPECTED_ERROR);
    }

}
