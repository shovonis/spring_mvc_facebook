package net.therap.SpringMVCFacebook.controller.user;

import net.therap.SpringMVCFacebook.domain.user.User;
import net.therap.SpringMVCFacebook.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

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

    private User user;

    @RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
    public ModelAndView showUserProfile(@PathVariable long userId) {
        user = userService.getUserById(userId);
        return new ModelAndView("user_profile", "profile", user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("profile") User userProfile, BindingResult result,
                             @RequestParam(value = "profilePicture") MultipartFile image) {

        userProfile.setUserId(user.getUserId());


        // This is needed because command object cannot bind list from form;
        userProfile.setFriends(user.getFriends());


        if (result.hasErrors()) {
            log.debug("Entity User binding error on updating userProfile profile");
            System.out.println("Entity User binding error on updating userProfile profile");
            return "redirect:/profile/" + user.getUserId();
        }
        try {
            byte[] proPic = image.getBytes();
            userProfile.getUserDetails().setProfilePicture(proPic);
        } catch (IOException e) {
            e.printStackTrace();
        }
        userProfile.getFriends();
        userService.updateUser(userProfile);
        return "redirect:/home";
    }

    @RequestMapping(value = "/getFriends/{userId}", method = RequestMethod.GET)
    public String getFriends(@PathVariable long userId) {
        List<User> friendLists = userService.getFriendList(userId);
        for (User friendList : friendLists) {
            System.out.println(friendList.getUserId());
        }
        return "redirect:/home";
    }

    @RequestMapping("/getPicture")
    @ResponseBody
    public byte[] getProfilePicture() {
        return user.getUserDetails().getProfilePicture();
    }


}
