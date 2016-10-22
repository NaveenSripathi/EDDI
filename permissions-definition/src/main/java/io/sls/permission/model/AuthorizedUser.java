package io.sls.permission.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URI;
import java.util.List;

/**
 * User: jarisch
 * Date: 07.09.12
 * Time: 15:21
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorizedUser {
    private URI user;
    private List<Integer> versions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorizedUser that = (AuthorizedUser) o;

        return user.equals(that.user);

    }

    @Override
    public int hashCode() {
        return user.hashCode();
    }
}
