package com.maktab.repository.impl;


import com.maktab.base.repository.impl.BaseRepositoryImpl;
import com.maktab.domain.Company;
import com.maktab.repository.CompanyRepository;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyRepositoryImpl extends BaseRepositoryImpl<Company, Long> implements CompanyRepository {


    public CompanyRepositoryImpl(EntityManagerFactory managerFactory) {
        super(managerFactory);
    }

    @Override
    public Class<Company> getEntityClass() {
        return Company.class;
    }
}
