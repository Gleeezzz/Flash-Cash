package com.umbert.flashcash1.controller;//package com.umbert.flashcash1.controller;


import org.springframework.ui.Model;
import com.umbert.flashcash1.model.Transfer;
import com.umbert.flashcash1.model.User;
import com.umbert.flashcash1.service.form.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private final LinkService linkService;
    private final UserService userService;
    private final TransferService transferService;
    private final SessionService sessionService;

    public UserController(LinkService linkService, UserService userService, TransferService transferService, SessionService sessionService) {

        this.linkService = linkService;
        this.userService = userService;
        this.transferService = transferService;
        this.sessionService = sessionService;

    }

    /*
    private ISpringTemplateEngine templateEngine(ITemplateResolver templateResolver){
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.addDialect(new. Java8TimeDialect());
        engine.setTemplateResolver(templateResolver);
        return engine;
     */



    @GetMapping("/")
    public ModelAndView home(Model model) {
        User user = sessionService.sessionUser();
        model.addAttribute("user", user);
        List<Transfer> transactions = transferService.findTransactions();
        model.addAttribute("transfers", transactions);
        return new ModelAndView("index");
    }

    @GetMapping("/signup")
    public ModelAndView showRegisterForm() {
        return new ModelAndView("signup", "signUpForm", new SignUpForm());
    }

    @PostMapping("/signup")
    public ModelAndView processRequest(@ModelAttribute("signUpForm") SignUpForm form) {
        try {
            User savedUser = userService.registration(form);
            System.out.println("✅ User saved: " + savedUser.getEmail());
            return new ModelAndView("redirect:/signin");
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("redirect:/signup");
        }
    }


    @GetMapping("/signin")
    public ModelAndView showSignInForm() {
        return new ModelAndView("signin");
    }
}




