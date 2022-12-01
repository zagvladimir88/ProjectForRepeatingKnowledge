package org.zagvladimir.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.zagvladimir.spring.database.entity.Company;
import org.zagvladimir.spring.database.repository.CrudRepository;
import org.zagvladimir.spring.dto.CompanyReadDto;
import org.zagvladimir.spring.listener.entity.AccessType;
import org.zagvladimir.spring.listener.entity.EntityEvent;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CrudRepository<Integer, Company> companyRepository;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;


    public Optional<CompanyReadDto> findById(Integer id){
        return companyRepository.findById(id)
                .map(entity -> {
                    eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.id());
                });
    }

}
