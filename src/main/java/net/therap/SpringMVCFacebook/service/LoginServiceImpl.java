package net.therap.SpringMVCFacebook.service;

import net.therap.SpringMVCFacebook.dao.UserDao;
import net.therap.SpringMVCFacebook.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author rifatul.islam
 * @since 6/18/14.
 */

@Service
@Transactional("transactionManager")
@Qualifier("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    private User user = null;

    @Override
    public boolean isUserVerified(String email, String password) {
        user = userDao.getUserByUserNamePassword(email, password);
        return user != null;
    }

    @Override
    public User getUser() {
        return user;
    }
}
