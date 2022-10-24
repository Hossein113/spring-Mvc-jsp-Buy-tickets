package com.maktab.service.impl;


import com.maktab.base.service.impl.BaseServiceImpl;
import com.maktab.domain.Company;
import com.maktab.repository.CompanyRepository;
import com.maktab.service.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends BaseServiceImpl<Company, Long, CompanyRepository> implements CompanyService {


    public CompanyServiceImpl(CompanyRepository repository) {
        super(repository);
    }
}

