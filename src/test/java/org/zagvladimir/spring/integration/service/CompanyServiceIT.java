package org.zagvladimir.spring.integration.service;

import org.zagvladimir.spring.integration.annotaion.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.zagvladimir.spring.config.DatabaseProperties;
import org.zagvladimir.spring.dto.CompanyReadDto;
import org.zagvladimir.spring.service.CompanyService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;


//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ApplicationRunner.class,
//        initializers = ConfigDataApplicationContextInitializer.class)
@IT
@RequiredArgsConstructor
public class CompanyServiceIT {

    private static final Integer COMPANY_ID = 1;
    private final CompanyService companyService;
    private final DatabaseProperties databaseProperties;

    @Test
    void findById() {

        var actualResult = companyService.findById(COMPANY_ID);
        assertTrue(actualResult.isPresent());
        var expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));

    }
}
