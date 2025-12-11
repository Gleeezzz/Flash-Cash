package com.umbert.flashcash1.controller;//package com.umbert.flashcash1.controller;


import com.umbert.flashcash1.service.form.SignUpForm;
import com.umbert.flashcash1.service.form.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

   /* private final LinkService linkService;
    private final UserService userService;
    private final TransferService transferService;
    private final SessionService sessionService;

    public UserController(LinkService linkService, UserService userService, TransferService transferService, SessionService sessionService){


    this.linkService = linkService;
    this.userService = userService;
    this.transferService = transferService;
    this.sessionService = sessionService;

    }

    */

    @GetMapping("/signup")
    public ModelAndView showRegisterForm(){
        return new ModelAndView("signup", "signUpForm", new SignUpForm());
    }

    @PostMapping("/signup")
    public ModelAndView processRequest(@ModelAttribute("signUpForm") SignUpForm form) {
        UserService.registration(form);
        return new ModelAndView("signin");
    }
}


