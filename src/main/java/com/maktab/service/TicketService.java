package com.maktab.service;


import com.maktab.base.service.BaseService;
import com.maktab.domain.Ticket;

import java.util.List;

public interface TicketService extends BaseService<Ticket, Long> {

    List<Ticket> findByAllfilter(String origin, String distion, String sortBy);

    List<Ticket> findByOriginAndDestAndDate(String origin, String destion, String date);

    Ticket findByIdWithQuri(Long id);


}
