package com.maktab.repository.impl;


import com.maktab.base.repository.impl.BaseRepositoryImpl;
import com.maktab.domain.User;
import com.maktab.repository.UserRepository;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long> implements UserRepository {


    public UserRepositoryImpl(EntityManagerFactory managerFactory) {
        super(managerFactory);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User findByUserNameAndPassword(String userName, String password) {
        return entityManager.createQuery("select u from User u where u.userName= :userName " +
                        "and u.password= :password", User.class).setParameter("userName", userName)
                .setParameter("password", password).getSingleResult();
    }

    @Override
    public Long countUser(String userName, String password) {
        return entityManager.createQuery("select count(id) from User u where u.userName=:username and" +
                        " u.password=:password", Long.class).setParameter("username", userName)
                .setParameter("password", password).getSingleResult();
    }


}
