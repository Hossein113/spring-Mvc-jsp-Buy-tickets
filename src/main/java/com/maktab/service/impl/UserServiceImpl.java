package com.maktab.service.impl;


import com.maktab.base.service.impl.BaseServiceImpl;
import com.maktab.domain.User;
import com.maktab.repository.UserRepository;
import com.maktab.service.UserService;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements UserService {


    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User findByUserNameAndPassword(String userName, String password) {
        try {
            return repository.findByUserNameAndPassword(userName, password);

        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public Long countUser(String userName, String password) {
        return repository.countUser(userName, password);
    }
}


