package io.sls.permission.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: jarisch
 * Date: 29.08.12
 * Time: 10:43
 */
@Getter
@Setter
public class AuthorizedSubjects {
    private List<AuthorizedUser> users;
    private List<AuthorizedGroup> groups;

    public AuthorizedSubjects() {
        this.users = new ArrayList<>();
        this.groups = new ArrayList<>();
    }
}
