package org.zagvladimir.spring.service;

import org.springframework.stereotype.Service;
import org.zagvladimir.spring.database.entity.Company;
import org.zagvladimir.spring.database.repository.CrudRepository;
import org.zagvladimir.spring.database.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

    public UserService(UserRepository userRepository, CrudRepository<Integer, Company> companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

}
