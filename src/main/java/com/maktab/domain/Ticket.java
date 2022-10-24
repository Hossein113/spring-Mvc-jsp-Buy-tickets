package com.maktab.domain;


import com.maktab.base.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "ticket_table")
public class Ticket extends BaseEntity<Long> {


    private String origin;
    private String destination;
    private String moveDate;
    private String moveTime;
    private String travelCode;
    private String ticketCode;


    public Ticket() {
    }

    public Ticket(Long aLong, String origin, String destination, String moveDate, String moveTime, String travelCode, String ticketCode) {
        super(aLong);

        this.origin = origin;
        this.destination = destination;
        this.moveDate = moveDate;
        this.moveTime = moveTime;
        this.travelCode = travelCode;
        this.ticketCode = ticketCode;
    }

    public Ticket(String origin, String destination, String moveDate, String moveTime, String travelCode, String ticketCode) {

        this.origin = origin;
        this.destination = destination;
        this.moveDate = moveDate;
        this.moveTime = moveTime;
        this.travelCode = travelCode;
        this.ticketCode = ticketCode;
    }


    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMoveDate() {
        return moveDate;
    }

    public void setMoveDate(String moveDate) {
        this.moveDate = moveDate;
    }

    public String getMoveTime() {
        return moveTime;
    }

    public void setMoveTime(String moveTime) {
        this.moveTime = moveTime;
    }

    public String getTravelCode() {
        return travelCode;
    }

    public void setTravelCode(String travelCode) {
        this.travelCode = travelCode;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    @Override
    public String toString() {
        return
                ", origin='" + origin + '\'' +
                        ", destination='" + destination + '\'' +
                        ", moveDate='" + moveDate + '\'' +
                        ", moveTime='" + moveTime + '\'' +
                        ", travelCode='" + travelCode + '\'' +
                        ", ticketCode='" + ticketCode + '\'';
    }
}

