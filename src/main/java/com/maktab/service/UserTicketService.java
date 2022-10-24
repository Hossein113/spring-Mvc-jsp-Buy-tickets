package com.maktab.service;


import com.maktab.base.service.BaseService;
import com.maktab.domain.User;
import com.maktab.domain.UserTicket;

import java.util.List;

public interface UserTicketService extends BaseService<UserTicket, Long> {
    List<UserTicket> findtickrtForUser(User user);

}
