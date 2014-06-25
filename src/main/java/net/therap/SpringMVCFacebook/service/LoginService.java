package net.therap.SpringMVCFacebook.service;

import net.therap.SpringMVCFacebook.domain.user.User;

/**
 * @author rifatul.islam
 * @since 6/18/14.
 */
public interface LoginService {
    public boolean isUserVerified(String email, String password);

    public User getUser();
}
