package com.maktab.service;


import com.maktab.base.service.BaseService;
import com.maktab.domain.User;

public interface UserService extends BaseService<User, Long> {
    User findByUserNameAndPassword(String userName, String password);

    Long countUser(String userName, String password);
}
