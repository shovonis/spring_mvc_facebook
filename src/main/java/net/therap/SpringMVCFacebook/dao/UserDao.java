package net.therap.SpringMVCFacebook.dao;

import net.therap.SpringMVCFacebook.domain.user.Comment;
import net.therap.SpringMVCFacebook.domain.user.User;

import java.util.List;

/**
 * @author rifatul.islam
 * @since 6/18/14.
 */


public interface UserDao {
    public User getUserById(long userId);

    public void saveUser(User user);

    public List<User> getAllUser();

    public void deleteUser(User user);

    public void updateUser(User user);

    public User getUserByUserNamePassword(String email, String password);

    public Comment getUserComment(long userId);

    public List<User> getFriendList(long userId);

}
