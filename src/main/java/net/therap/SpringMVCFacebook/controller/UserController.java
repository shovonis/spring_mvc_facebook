package net.therap.SpringMVCFacebook.controller;

import net.therap.SpringMVCFacebook.domain.User;
import net.therap.SpringMVCFacebook.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author rifatul.islam
 * @since 6/19/14.
 */

@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    @Qualifier("userService")
    private UserService userService;


    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView showUserProfile(HttpSession session) {
        User user = (User) session.getAttribute("user");
//        System.out.println("User in profile " + user);
        return new ModelAndView("user_profile", "profile", user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("profile") User user, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "redirect:/profile";
        }
        User userFromSession = (User) session.getAttribute("user");
        user.setUserId(userFromSession.getUserId());
        System.out.println("user id in update " + user.getUserId());
        System.out.println("user email in update " + user.getEmail());
        System.out.println("user first name in update " + user.getUserDetails().getFirstName());
        userService.updateUser(user);
        return "redirect:/home";
    }
}
