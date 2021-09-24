package com.amdocs.media.assignement.com.amdocs.media.assignement.repository;

import com.amdocs.media.assignement.com.amdocs.media.assignement.dao.LoginForm;
import com.amdocs.media.assignement.com.amdocs.media.assignement.dao.RegistrationForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizationServiceRepository extends CrudRepository<RegistrationForm, Long> {
    RegistrationForm findByUsername(String name);
}
