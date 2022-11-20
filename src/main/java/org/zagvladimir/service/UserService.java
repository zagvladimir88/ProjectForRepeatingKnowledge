package org.zagvladimir.service;

import org.zagvladimir.database.repository.CompanyRepository;
import org.zagvladimir.database.repository.UserRepository;

public class UserService {

    private final UserRepository  userRepository;
    private final CompanyRepository companyRepository;
    private CompanyService companyService;


    public UserService(UserRepository userRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }
}
