package org.zagvladimir.spring.integration.service;

import org.springframework.test.annotation.DirtiesContext;
import org.zagvladimir.spring.integration.annotaion.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.zagvladimir.spring.database.pool.ConnectionPool;
import org.zagvladimir.spring.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@IT
@RequiredArgsConstructor
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserServiceIT {

    private final UserService userService;
    private final ConnectionPool pool1;

    @Test
    void test(){
        System.out.println();
    }

    @Test
    void test2(){
        System.out.println();
    }
}
