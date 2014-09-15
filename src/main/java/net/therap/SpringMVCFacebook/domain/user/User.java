package net.therap.SpringMVCFacebook.domain.user;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author rifatul.islam
 * @since 6/18/14.
 */

@Entity
@Table(name = "USER")
@Scope("session")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private long userId;

    @NotEmpty
    @Column(name = "PASSWORD", nullable = false)
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
    private Set<User> friends;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Post> post;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Comment> comments;

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

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public Set<Post> getPost() {
        return post;
    }

    public void setPost(Set<Post> post) {
        this.post = post;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "userId=" + userId +
//                ", password='" + password + '\'' +
//                ", email='" + email + '\'' +
//                ", userDetails=" + userDetails +
//                ", friends=" + friends +
//                ", post=" + post +
//                ", comments=" + comments +
//                '}';
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (userId != user.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (userId ^ (userId >>> 32));
    }
}
