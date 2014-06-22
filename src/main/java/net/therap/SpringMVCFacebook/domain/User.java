package net.therap.SpringMVCFacebook.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.List;

/**
 * @author rifatul.islam
 * @since 6/18/14.
 */

@Entity
@Table(name = "USER")
@Scope("session")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID",nullable = false)
    private long userId;

    @NotEmpty
    @Column(name = "PASSWORD",nullable = false)
    private String password;

    @NotEmpty
    @Column(name = "EMAIL")
    private String email;

    @Embedded
    private UserDetails userDetails;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "FRIENDSHIP",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FRIEND_ID"))
    private List<User> friends;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Post> post;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Comment> comments;

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userDetails=" + userDetails +
                ", friends=" + friends +
                ", post=" + post +
                ", comments=" + comments +
                '}';
    }
}
