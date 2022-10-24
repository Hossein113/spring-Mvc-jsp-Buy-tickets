package com.maktab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @GetMapping("/")
    public ModelAndView getIndex() {
        return new ModelAndView("index");
    }

    @GetMapping("/test")
    public ModelAndView getTEst() {
        return new ModelAndView("index");
    }

}
