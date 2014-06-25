package net.therap.SpringMVCFacebook.domain.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author rifatul.islam
 * @since 6/24/14.
 */

public class LoginForm {
    @NotEmpty(message = "Email must not be empty")
    @NotNull
    private String email;

    @NotEmpty(message = "Password must not be empty")
    @NotNull
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
