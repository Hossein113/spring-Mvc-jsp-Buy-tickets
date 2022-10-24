package com.maktab.domain;


import com.maktab.base.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_ticket")
public class UserTicket extends BaseEntity<Long> {

    private String gender;

    private String nameUserTicket;
    @OneToOne
    private Ticket ticketUser;
    @OneToOne
    private User user;

    public UserTicket() {
    }

    public UserTicket(String gender, String nameUserTicket, Ticket ticketUser, User user) {
        this.gender = gender;
        this.nameUserTicket = nameUserTicket;
        this.ticketUser = ticketUser;
        this.user = user;
    }

    public UserTicket(Long aLong, String gender, String nameUserTicket, Ticket ticketUser, User user) {
        super(aLong);
        this.gender = gender;
        this.nameUserTicket = nameUserTicket;
        this.ticketUser = ticketUser;
        this.user = user;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNameUserTicket() {
        return nameUserTicket;
    }

    public void setNameUserTicket(String nameUserTicket) {
        this.nameUserTicket = nameUserTicket;
    }

    public Ticket getTicketUser() {
        return ticketUser;
    }

    public void setTicketUser(Ticket ticketUser) {
        this.ticketUser = ticketUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return
                "gender='" + gender + '\'' +
                        ", nameUserTicket='" + nameUserTicket + '\'' +
                        ", ticketUser=" + ticketUser;
    }
}