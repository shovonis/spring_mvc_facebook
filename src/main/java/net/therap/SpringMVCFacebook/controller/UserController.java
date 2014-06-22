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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author rifatul.islam
 * @since 6/19/14.
 */

@Controller
@SessionAttributes("user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHomePage(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/login";
        }
        return "home";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView showUserProfile(@ModelAttribute("user") User user, BindingResult result) {
        log.debug("USER EMAIL IS " + user.getEmail());
        return new ModelAndView("user_profile", "profile", user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("profile") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/profile";
        }
        System.out.println(user.getUserId());
        System.out.println(user.getEmail());
        System.out.println(user.getUserDetails().getFirstName());
        userService.updateUser(user);
        return "redirect:/home";
    }
}
