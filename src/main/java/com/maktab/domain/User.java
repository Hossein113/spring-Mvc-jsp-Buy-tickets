package com.maktab.domain;


import com.maktab.base.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_table")
public class User extends BaseEntity<Long> {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public User() {
    }

    public User(String firstNAme, String lastNAme, String userName, String password) {
        this.firstName = firstNAme;
        this.lastName = lastNAme;
        this.userName = userName;
        this.password = password;
    }

    public User(Long aLong, String firstNAme, String lastNAme, String userName, String password) {
        super(aLong);
        this.firstName = firstNAme;
        this.lastName = lastNAme;
        this.userName = userName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return
                "firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\''
                ;

    }
}
