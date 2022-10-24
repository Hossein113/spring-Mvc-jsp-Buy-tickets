package com.maktab.util;


import com.maktab.base.domain.BaseEntity;
import com.maktab.domain.Company;

public class SecurityCompany extends BaseEntity<Long> {

    private Company curentCompany;

    public SecurityCompany() {
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
