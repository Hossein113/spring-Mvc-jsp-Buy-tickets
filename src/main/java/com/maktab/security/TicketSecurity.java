package com.maktab.security;


import com.maktab.base.domain.BaseEntity;
import com.maktab.domain.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketSecurity extends BaseEntity<Long> {
    private Ticket currenticket;

    public Ticket getCurrenticket() {
        return currenticket;
    }

    public void setCurrenticket(Ticket currenticket) {
        this.currenticket = currenticket;
    }

    public void logout() {
        this.currenticket = null;
    }
}
