package com.maktab.controller;


import com.maktab.domain.Ticket;
import com.maktab.domain.User;
import com.maktab.domain.UserTicket;
import com.maktab.security.TicketSecurity;
import com.maktab.security.UserSecurity;
import com.maktab.service.TicketService;
import com.maktab.service.UserService;
import com.maktab.service.UserTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/ticket")
@RequiredArgsConstructor

public class TicketContriller {
    private final UserService userService;
    private final UserSecurity userSecurity;
    private final UserTicketService userTicketService;
    private final TicketService ticketService;
    private final TicketSecurity ticketSecurity;


    @GetMapping("/search")
    public ModelAndView buyTicket() {

        return new ModelAndView("select");

    }


    @PostMapping("/search-ticket")
    public ModelAndView searchTicket(@RequestParam String origin, @RequestParam String dist, @RequestParam String date) {

        ModelAndView modelAndView = new ModelAndView("select");

        List<Ticket> showTickets = ticketService.findByOriginAndDestAndDate(origin, dist, date);


        if (showTickets.size() != 0) {
            modelAndView.addObject("hasTicket", true);
            modelAndView.addObject("search", showTickets);
            modelAndView.addObject("source", showTickets.get(0).getOrigin());
            modelAndView.addObject("dest", showTickets.get(0).getDestination());
            modelAndView.addObject("time", showTickets.get(0).getMoveDate());


        } else {
            modelAndView.addObject("hasTicket", false);
            modelAndView.addObject("nofind", "موردی یافت نشد");

        }

        return modelAndView;
    }


    @RequestMapping("/submit-ticket")
    public ModelAndView submitTicket(@RequestParam String ticketId) {
        ModelAndView modelAndView = new ModelAndView();

        Long id = Long.valueOf(ticketId);

        Ticket ticket = ticketService.findByIdWithQuri(id);
        if (ticket != null) {
            ticketSecurity.setCurrenticket(ticket);
        }

        modelAndView.setViewName("selectGender");

        return modelAndView;

    }


    @RequestMapping("/buy-ticket")
    public ModelAndView buyTicket(@RequestParam String name, @RequestParam String gender) {

        ModelAndView modelAndView = new ModelAndView("successfulyBuy");


        Ticket currenticket = ticketSecurity.getCurrenticket();
        User currentUser = userSecurity.getCurrentUser();
        UserTicket userTicket = new UserTicket(gender, name, currenticket, currentUser);

        UserTicket userTicketNow = userTicketService.save(userTicket);
        String ticketCode = currenticket.getTicketCode();
        String nameUserTicket = userTicketNow.getNameUserTicket();
        String gender1 = userTicketNow.getGender();
        modelAndView.addObject("name", nameUserTicket);
        modelAndView.addObject("codeTicket", ticketCode);
        modelAndView.addObject("ticketId", currenticket.getId());


        if (gender1.equals("female")) {
            modelAndView.addObject("gender", "خانم");

        } else {
            modelAndView.addObject("gender", "آقا");
        }

        return modelAndView;

    }


    @RequestMapping("/show-buy-ticket")
    public ModelAndView showBuyTicket() {
        ModelAndView modelAndView = new ModelAndView();

        User currentUser = userSecurity.getCurrentUser();
        modelAndView.addObject("user", currentUser);
        List<UserTicket> userTickets = userTicketService.findtickrtForUser(currentUser);
        modelAndView.addObject("listTicket", userTickets);
        modelAndView.setViewName("showTicketBuy");
        return modelAndView;
    }


    @RequestMapping("/show-info-ticket")
    public ModelAndView showInfoTicket(@RequestParam String ticketId) {

        ModelAndView modelAndView = new ModelAndView();
        Long ticket = Long.valueOf(ticketId);
        UserTicket tiket = userTicketService.findById(ticket);


        modelAndView.addObject("ticketCode", tiket.getTicketUser().getTicketCode());
        modelAndView.addObject("userTicket", tiket.getNameUserTicket());
        modelAndView.addObject("gender", tiket.getGender());
        modelAndView.addObject("origin", tiket.getTicketUser().getOrigin());
        modelAndView.addObject("dest", tiket.getTicketUser().getDestination());
        modelAndView.addObject("date", tiket.getTicketUser().getMoveDate());
        modelAndView.addObject("time", tiket.getTicketUser().getMoveTime());
        modelAndView.addObject("travelCode", tiket.getTicketUser().getTravelCode());
        modelAndView.addObject("ticket", tiket.getId());

        modelAndView.setViewName("showInfo");
        return modelAndView;

    }


    @RequestMapping(value = "/delet-ticket")
//    @DeleteMapping("/delet-ticket")

    public ModelAndView deletTicket(@RequestParam String ticketUser) {


        ModelAndView modelAndView = new ModelAndView();
        if (
                ticketUser != null
        ) {
            Long ticket = Long.valueOf(ticketUser);
            userTicketService.deleteById(ticket);
            modelAndView.setViewName("deletTicket");
        }
        return modelAndView;
    }


}