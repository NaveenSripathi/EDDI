package io.sls.resources.rest.extensions.model;

import lombok.Getter;
import lombok.Setter;

/**
 * User: jarisch
 * Date: 12.09.12
 * Time: 15:03
 */
@Setter
@Getter
public class InputField {
    private String type;
    private String defaultValue;
    private String displayKey;
}
