package com.amdocs.media.assignement.com.amdocs.media.assignement.service;
import com.amdocs.media.assignement.com.amdocs.media.assignement.dao.LoginForm;
import com.amdocs.media.assignement.com.amdocs.media.assignement.dao.RegistrationForm;
import com.amdocs.media.assignement.com.amdocs.media.assignement.repository.AuthorizationServiceRepository;
import com.amdocs.media.assignement.com.amdocs.media.assignement.repository.RegistrationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    Logger logger = LoggerFactory.getLogger(AuthorizationService.class);

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private AuthorizationServiceRepository authorizationServiceRepository;

    public Boolean registerUser(RegistrationForm registrationForm){
        try {
            if (null != registrationForm) {
                registrationRepository.save(registrationForm);
            }
            return true;
        } catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public Boolean isUserExistsInDatabase(LoginForm loginForm){
        try {
            if (null != loginForm) {
                RegistrationForm registrationForm = authorizationServiceRepository.findByUsername(loginForm.getUsername());
                if (null != registrationForm ) {
                    logger.info("First name :"+registrationForm.getFirstname() + " and LastName :"+registrationForm.getLastName());
                    if (null!= loginForm.getUsername() && loginForm.getUsername().equalsIgnoreCase(registrationForm.getUsername()) && null!= loginForm.getPassword() &&
                                    loginForm.getPassword().equalsIgnoreCase(registrationForm.getPassword())){
                        logger.info("username & password matched with DB");
                        //new api will called using restemplate
                        return true;
                    }
                    logger.info("username & password doesn't matched with DB");
                    return false;
                }
            }
            logger.info("loginForm is null , please check the input request");
            return false;
        } catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

}
