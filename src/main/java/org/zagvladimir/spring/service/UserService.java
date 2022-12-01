package org.zagvladimir.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zagvladimir.spring.database.entity.Company;
import org.zagvladimir.spring.database.repository.CrudRepository;
import org.zagvladimir.spring.database.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

}
