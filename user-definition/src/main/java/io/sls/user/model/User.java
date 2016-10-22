package io.sls.user.model;

import io.sls.user.IUser;
import lombok.Getter;
import lombok.Setter;

/**
 * User: jarisch
 * Date: 28.08.12
 * Time: 12:21
 */
@Getter
@Setter
public class User implements IUser {
    private String username;
    private String password;
    private String salt;
    private String email;
    private String displayName;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
