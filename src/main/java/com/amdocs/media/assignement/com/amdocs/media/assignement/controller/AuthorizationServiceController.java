package com.amdocs.media.assignement.com.amdocs.media.assignement.controller;

import com.amdocs.media.assignement.com.amdocs.media.assignement.dao.LoginForm;
import com.amdocs.media.assignement.com.amdocs.media.assignement.dao.RegistrationForm;
import com.amdocs.media.assignement.com.amdocs.media.assignement.service.AuthorizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationServiceController {
    Logger logger = LoggerFactory.getLogger(AuthorizationServiceController.class);

    @Autowired
    private AuthorizationService authorizationService;

    @PostMapping("/registerUser")
    public ResponseEntity<Boolean> registerUser(@RequestBody RegistrationForm registrationForm) {
        logger.info("Request received for registering the user");
        return new ResponseEntity<Boolean>(authorizationService.registerUser(registrationForm), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> authenticateUser(@RequestBody LoginForm loginFormVO) {
        logger.info("Request received for login");
        return new ResponseEntity<>(authorizationService.isUserExistsInDatabase(loginFormVO), HttpStatus.OK);

   }

}
