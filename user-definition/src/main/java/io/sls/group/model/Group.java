package io.sls.group.model;

import io.sls.group.IGroup;
import lombok.Getter;
import lombok.Setter;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

/**
 * User: jarisch
 * Date: 28.08.12
 * Time: 12:23
 */
@Getter
@Setter
public class Group implements IGroup {
    private String name;
    private List<URI> users;

    public Group() {
        this.users = new LinkedList<>();
    }
}
