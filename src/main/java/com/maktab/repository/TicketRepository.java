package com.maktab.repository;


import com.maktab.base.repository.BaseRepository;
import com.maktab.domain.Ticket;

import java.util.List;

public interface TicketRepository extends BaseRepository<Ticket, Long> {

    Ticket findByIdWithQuri(Long id);

    List<Ticket> findByAllfilter(String origin, String distion, String sortBy);

    List<Ticket> findByAllfilter(String origin, String distion, String sortBy, String direction);

    List<Ticket> findByOriginAndDestAndDate(String origin, String destion, String date);

}