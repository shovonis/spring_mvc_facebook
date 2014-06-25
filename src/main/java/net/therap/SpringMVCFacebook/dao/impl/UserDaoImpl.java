package net.therap.SpringMVCFacebook.dao.impl;

import net.therap.SpringMVCFacebook.dao.UserDao;
import net.therap.SpringMVCFacebook.domain.user.Comment;
import net.therap.SpringMVCFacebook.domain.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author rifatul.islam
 * @since 6/18/14.
 */

@Repository
@Qualifier("userDao")
public class UserDaoImpl implements UserDao {
    private static final Logger log = LoggerFactory.getLogger(HandlerInterceptor.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Cacheable(value = "USER", key = "#userId")
    @Override
    public User getUserById(long userId) {
        System.out.println("First Called");
        String qu = "SELECT user FROM User user " +
                "LEFT JOIN FETCH user.friends LEFT JOIN FETCH user.comments LEFT JOIN FETCH user.post " +
                "WHERE user.userId=:userId";

        TypedQuery<User> query = entityManager.createQuery(qu, User.class);

        query.setParameter("userId", userId);
        User user = query.getSingleResult();
        return user;
    }

    @Override
    public void saveUser(User user) {
        log.debug("INSERTING USER");
        entityManager.persist(user);
        entityManager.flush();
    }

    @Cacheable(value = "UserList")
    @Override
    public List<User> getAllUser() {
        //TODO:Get all user
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }

    @CacheEvict(value = "USER", key = "#user.userId")
    @Override
    public void updateUser(User user) {
        log.info("UPDATED User " + user.getUserId());

//        User us = entityManager.find(User.class, user.getUserId());
//        us.getFriends();

        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public User getUserByUserNamePassword(String email, String password) {
        User user = null;

        String qu = "SELECT user FROM User user " +
                "LEFT JOIN FETCH user.friends LEFT JOIN FETCH user.comments LEFT JOIN FETCH user.post" +
                " WHERE user.email=:email AND user.password=:password";
        try {
            TypedQuery<User> query = entityManager.createQuery(qu, User.class);

            query.setParameter("email", email);
            query.setParameter("password", password);
            user = query.getSingleResult();
        } catch (NoResultException exception) {
            log.error("NO SUCH RESULT FOUND FOR THE QUERY");
        } finally {
            return user;
        }
    }

    @Override
    public Comment getUserComment(long userId) {
        TypedQuery<Comment> query = entityManager.createQuery("SELECT comment" +
                " FROM Comment comment WHERE comment.user.userId=:userId", Comment.class);
        query.setParameter("userId", userId);
        Comment comment = query.getSingleResult();
        return comment;
    }


    @Override
    public List<User> getFriendList(long userId) {
        log.debug("Getting Friend Lists");
        TypedQuery<User> query = entityManager.createQuery("SELECT friend FROM User user " +
                "JOIN user.friends friend WHERE user.userId=:userId", User.class);

        query.setParameter("userId", userId);
        List<User> friendList = query.getResultList();
        log.debug("Friend List Returned");
        return friendList;
    }
}
