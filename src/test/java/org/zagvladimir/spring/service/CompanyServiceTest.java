package org.zagvladimir.spring.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.zagvladimir.spring.database.entity.Company;
import org.zagvladimir.spring.database.repository.CrudRepository;
import org.zagvladimir.spring.dto.CompanyReadDto;
import org.zagvladimir.spring.listener.entity.EntityEvent;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {
    private static final Integer COMPANY_ID = 1;

    @Mock
    private  CrudRepository<Integer, Company> companyRepository;
    @Mock
    private  UserService userService;
    @Mock
    private  ApplicationEventPublisher eventPublisher;
    @InjectMocks
    private CompanyService companyService;


    @Test
    void findById() {
        doReturn(Optional.of(new Company(COMPANY_ID,null, Collections.emptyMap())))
                .when(companyRepository).findById(COMPANY_ID);
        var actualResult = companyService.findById(COMPANY_ID);
    assertTrue(actualResult.isPresent());
    var expectedResult = new CompanyReadDto(COMPANY_ID);
    actualResult.ifPresent(actual->assertEquals(expectedResult,actual));

    verify(eventPublisher).publishEvent(any(EntityEvent.class));
    verifyNoMoreInteractions(eventPublisher,userService);
    }


}