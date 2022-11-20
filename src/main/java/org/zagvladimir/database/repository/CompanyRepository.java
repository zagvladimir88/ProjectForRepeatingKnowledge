package org.zagvladimir.database.repository;

import org.zagvladimir.bpp.Auditing;
import org.zagvladimir.bpp.InjectBean;
import org.zagvladimir.bpp.Transaction;
import org.zagvladimir.database.entity.Company;
import org.zagvladimir.database.pool.ConnectionPool;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Auditing
@Transaction
public class CompanyRepository implements CrudRepository<Integer, Company>{


    @InjectBean
    private ConnectionPool connectionPool;


    @PostConstruct
    private void init() {
        System.out.println("Init company repository");
    }


    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("FindById method...");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("Delete method...");
    }
}
