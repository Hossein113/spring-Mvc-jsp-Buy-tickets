package com.maktab.repository;


import com.maktab.base.repository.BaseRepository;
import com.maktab.domain.User;
import com.maktab.domain.UserTicket;

import java.util.List;


public interface UserTicketRepository extends BaseRepository<UserTicket, Long> {

    List<UserTicket> findtickrtForUser(User user);


}
