package com.maktab.controller;

import com.maktab.domain.User;
import com.maktab.security.UserSecurity;
import com.maktab.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserSecurity userSecurity;

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password) {
        ModelAndView modelAndView = new ModelAndView();
        User checkUser = userService.findByUserNameAndPassword(username, password);
        if (checkUser != null) {
            userSecurity.setCurrentUser(checkUser);
            modelAndView.setViewName("select");
        } else {
            modelAndView.addObject("message", "username or password is wrong !!!");
            modelAndView.setViewName("index");
        }
        return modelAndView;
    }

    @PostMapping("/sign-up")
    public ModelAndView sign(@RequestParam String username, @RequestParam String password,
                             @RequestParam String lastname, @RequestParam String firstname) {
        return signUpFirstMethod(username, password, lastname, firstname);
//        return signUpSecondMethod(username, password, lastname, firstname);
    }

    private ModelAndView signUpFirstMethod(String username, String password,
                                           String lastname, String firstname) {
        ModelAndView modelAndView = new ModelAndView("index");
        User user = new User(firstname, lastname, username, password);
        modelAndView.addObject("save", "successfully signup !");
        User save = userService.save(user);
        return modelAndView;
    }

    private ModelAndView signUpSecondMethod(String username, String password,
                                            String lastname, String firstname) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        User user = new User(firstname, lastname, username, password);
        modelAndView.addObject("save", "successfully signup !");
        User save = userService.save(user);

        return modelAndView;
    }

}

