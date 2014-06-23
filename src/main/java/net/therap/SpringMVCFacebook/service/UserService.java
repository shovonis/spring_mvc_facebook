package net.therap.SpringMVCFacebook.service;

import net.therap.SpringMVCFacebook.domain.Comment;
import net.therap.SpringMVCFacebook.domain.User;

import java.util.List;

/**
 * @author rifatul.islam
 * @since 6/19/14.
 */
public interface UserService {

    public Comment getUserComment(long userId);

    public void saveUser(User user);

    public void updateUser(User user);

    public User getUserById(long userId);

    public List<User> getFriendList(long userId);
}
