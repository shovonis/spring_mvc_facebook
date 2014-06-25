package net.therap.SpringMVCFacebook.controller.user;

import net.therap.SpringMVCFacebook.domain.user.User;
import net.therap.SpringMVCFacebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author rifatul.islam
 * @since 6/22/14.
 */

@Controller
public class UserRegController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView showRegisterForm() {
        return new ModelAndView("registration_form", "user", new User());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/signup";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }
}
