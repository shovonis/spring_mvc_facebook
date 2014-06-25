package net.therap.SpringMVCFacebook.controller.user;

import net.therap.SpringMVCFacebook.domain.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author shovon
 * @since 6/22/14.
 */

@Controller
@SessionAttributes("user")
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHomePage(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/login";
        }
        return "home";
    }
}
