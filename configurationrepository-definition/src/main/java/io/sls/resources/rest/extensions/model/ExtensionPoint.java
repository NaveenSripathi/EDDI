package io.sls.resources.rest.extensions.model;

import lombok.Getter;
import lombok.Setter;

import java.net.URI;

/**
 * User: jarisch
 * Date: 12.09.12
 * Time: 14:55
 */
@Getter
@Setter
public class ExtensionPoint {
    private URI namespace;
    private String interfaceClass;
    private String displayKey;
}
