package com.maktab.service.impl;


import com.maktab.base.service.impl.BaseServiceImpl;
import com.maktab.domain.User;
import com.maktab.domain.UserTicket;
import com.maktab.repository.UserTicketRepository;
import com.maktab.service.UserTicketService;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTicketServiceImpl extends BaseServiceImpl<UserTicket, Long, UserTicketRepository> implements UserTicketService {

    public UserTicketServiceImpl(UserTicketRepository repository) {
        super(repository);
    }

    @Override
    public List<UserTicket> findtickrtForUser(User user) {
        try {
            return repository.findtickrtForUser(user);
        } catch (NoResultException e) {
            return null;
        }
    }
}
