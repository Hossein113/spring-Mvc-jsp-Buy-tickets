package com.maktab.repository;


import com.maktab.base.repository.BaseRepository;
import com.maktab.domain.User;

public interface UserRepository extends BaseRepository<User, Long> {

    User findByUserNameAndPassword(String userName, String password);

    Long countUser(String userName, String password);
}
