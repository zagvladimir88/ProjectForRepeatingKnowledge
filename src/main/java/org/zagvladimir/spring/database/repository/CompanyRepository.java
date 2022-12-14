package org.zagvladimir.spring.database.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.zagvladimir.spring.bpp.Auditing;
import org.zagvladimir.spring.bpp.Transaction;
import org.zagvladimir.spring.database.entity.Company;
import org.zagvladimir.spring.database.pool.ConnectionPool;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Slf4j
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Auditing
@Transaction
@Repository
@RequiredArgsConstructor
public class CompanyRepository implements CrudRepository<Integer, Company>{

    private final ConnectionPool pool1;
    private final List<ConnectionPool> pools;
    @Value("${db.pool.size}")
    private final Integer poolSize;

    @PostConstruct
    private void init() {
        log.warn("Init company repository");
    }


    @Override
    public Optional<Company> findById(Integer id) {
        log.warn("FindById method...");
        return Optional.of(new Company(id,null, Collections.emptyMap()));
    }

    @Override
    public void delete(Company entity) {
        log.warn("Delete method...");
    }

}
