package net.therap.SpringMVCFacebook.service;

import net.therap.SpringMVCFacebook.dao.UserDao;
import net.therap.SpringMVCFacebook.domain.Comment;
import net.therap.SpringMVCFacebook.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author rifatul.islam
 * @since 6/19/14.
 */

@Service
@Qualifier("userService")
@Transactional("transactionManager")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    @Override
    public Comment getUserComment(long userId) {
        return null;
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getUserById(long userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public List<User> getFriendList(long userId) {
        return userDao.getFriendList(userId);
    }
}
