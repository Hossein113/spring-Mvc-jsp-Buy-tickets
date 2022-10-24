package com.maktab.repository.impl;


import com.maktab.base.repository.impl.BaseRepositoryImpl;
import com.maktab.domain.User;
import com.maktab.domain.UserTicket;
import com.maktab.repository.UserTicketRepository;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserTicketRepositoryImpl extends BaseRepositoryImpl<UserTicket, Long> implements UserTicketRepository {


    public UserTicketRepositoryImpl(EntityManagerFactory managerFactory) {
        super(managerFactory);
    }

    @Override
    public Class<UserTicket> getEntityClass() {
        return UserTicket.class;
    }

    @Override
    public List<UserTicket> findtickrtForUser(User user) {
        return entityManager.createQuery("select u from UserTicket u where u.user=:user", UserTicket.class)
                .setParameter("user", user).getResultList();
    }

}
