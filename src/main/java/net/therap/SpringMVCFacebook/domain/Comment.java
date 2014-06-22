package net.therap.SpringMVCFacebook.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author rifatul.islam
 * @since 6/18/14.
 */


@Entity
@Table(name = "COMMENT")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COM_ID")
    private long commentId;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Lob
    @Column(name = "BLOB_CONTENT")
    private byte[] blobContent;

    @Lob
    @Column(name = "TEXT_CONTENT")
    private String textContent;

    @Column(name = "TIME")
    private Timestamp time;

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public byte[] getBlobContent() {
        return blobContent;
    }

    public void setBlobContent(byte[] blobContent) {
        this.blobContent = blobContent;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
