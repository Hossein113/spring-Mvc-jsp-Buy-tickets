package com.maktab.domain;


import com.maktab.base.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "company_table")
public class Company extends BaseEntity<Long> {

    private String name;
    private String userName;
    private String password;

    public Company() {
    }

    public Company(Long aLong, String name, String userName, String password) {
        super(aLong);
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public Company(String name, String userName, String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Company='" + name + '\'';
    }
}
