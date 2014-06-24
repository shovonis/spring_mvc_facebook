package net.therap.SpringMVCFacebook.controller;

import net.therap.SpringMVCFacebook.domain.LoginForm;
import net.therap.SpringMVCFacebook.domain.User;
import net.therap.SpringMVCFacebook.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = {"/login","/"}, method = RequestMethod.GET)
    public ModelAndView printWelcome() {
        return new ModelAndView("login_form", "loginForm", new LoginForm());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult result) {

        boolean isUserVerified = loginService.isUserVerified(loginForm.getEmail(), loginForm.getPassword());
        ModelAndView modelAndView = new ModelAndView("login_form");

        if (isUserVerified) {
            User user = loginService.getUser();
            modelAndView.addObject("user", user);

            System.out.println("USER ID " + user.getUserId());
            System.out.println("EMAIL " + user.getEmail());
            System.out.println("PASS " + user.getPassword());

            modelAndView.setViewName("redirect:/home");
        }
        return modelAndView;
    }

}