package com.maktab.security;


import com.maktab.base.domain.BaseEntity;
import com.maktab.domain.User;
import org.springframework.stereotype.Component;

@Component

public class UserSecurity extends BaseEntity<Long> {
    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void logout() {
        this.currentUser = null;
    }
}
