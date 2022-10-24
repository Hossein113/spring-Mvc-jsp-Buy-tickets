package com.maktab.service.impl;


import com.maktab.base.service.impl.BaseServiceImpl;
import com.maktab.domain.Ticket;
import com.maktab.repository.TicketRepository;
import com.maktab.service.TicketService;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl extends BaseServiceImpl<Ticket, Long, TicketRepository> implements TicketService {


    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }

    @Override
    public List<Ticket> findByAllfilter(String origin, String distion, String sortBy) {
        return repository.findByAllfilter(origin, distion, sortBy);
    }


    @Override
    public List<Ticket> findByOriginAndDestAndDate(String origin, String destion, String date) {
        try {
            return repository.findByOriginAndDestAndDate(origin, destion, date);

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Ticket findByIdWithQuri(Long id) {
        try {
            return repository.findByIdWithQuri(id);
        } catch (NoResultException e) {
            return null;
        }
    }
}