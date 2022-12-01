package integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zagvladimir.ApplicationRunner;
import org.zagvladimir.spring.database.entity.Company;
import org.zagvladimir.spring.dto.CompanyReadDto;
import org.zagvladimir.spring.listener.entity.EntityEvent;
import org.zagvladimir.spring.service.CompanyService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ApplicationRunner.class,
//        initializers = ConfigDataApplicationContextInitializer.class)
@SpringBootTest(classes = ApplicationRunner.class)
public class CompanyServiceIT {
    private static final Integer COMPANY_ID = 1;
    @Autowired
    private CompanyService companyService;

    @Test
    void  findById(){

        var actualResult = companyService.findById(COMPANY_ID);
        assertTrue(actualResult.isPresent());
        var expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual->assertEquals(expectedResult,actual));

    }
}
