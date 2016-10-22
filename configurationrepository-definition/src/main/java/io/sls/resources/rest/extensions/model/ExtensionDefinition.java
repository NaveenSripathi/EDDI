package io.sls.resources.rest.extensions.model;

import lombok.Getter;
import lombok.Setter;

import java.net.URI;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * User: jarisch
 * Date: 11.09.12
 * Time: 12:07
 */
@Getter
@Setter
public class ExtensionDefinition {
    private URI type;
    private List<ExtensionPoint> extensionPoints;
    private Map<String, InputField> configDefinition;

    public ExtensionDefinition() {
        this.extensionPoints = new LinkedList<>();
        this.configDefinition = new HashMap<>();
    }
}
