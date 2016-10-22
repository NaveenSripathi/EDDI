package io.sls.resources.rest.descriptor.model;

import lombok.Getter;
import lombok.Setter;

import java.net.URI;
import java.util.Date;

/**
 * User: jarisch
 * Date: 18.11.12
 * Time: 17:19
 */
@Getter
@Setter
public class ResourceDescriptor {
    private URI resource;
    private URI createdBy;
    private Date createdOn;
    private URI lastModifiedBy;
    private Date lastModifiedOn;
    private boolean deleted;
}
