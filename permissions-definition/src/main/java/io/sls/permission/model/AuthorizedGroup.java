package io.sls.permission.model;

import lombok.Getter;
import lombok.Setter;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

/**
 * User: jarisch
 * Date: 07.09.12
 * Time: 15:21
 */
@Getter
@Setter
public class AuthorizedGroup {
    private URI group;
    private List<Integer> versions;

    public AuthorizedGroup() {
        this.versions = new LinkedList<Integer>();
    }
}
