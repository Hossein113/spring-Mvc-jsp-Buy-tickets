package com.maktab.security;


import com.maktab.base.domain.BaseEntity;
import com.maktab.domain.Company;
import org.springframework.stereotype.Component;

@Component

public class CompanySecurity extends BaseEntity<Long> {

    private Company curentCompany;

    public CompanySecurity() {
        this.curentCompany = curentCompany;
    }

    public Company getCurentCompany() {
        return curentCompany;
    }

    public void setCurentCompany(Company curentCompany) {
        this.curentCompany = curentCompany;
    }

    public void logout() {
        this.curentCompany = null;
    }

    @Override
    public String toString() {
        return
                "curentCompany=" + curentCompany;

    }
}
