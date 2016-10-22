package io.sls.resources.rest.output.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: jarisch
 * Date: 04.06.12
 * Time: 20:38
 */
@Getter
@Setter
public class OutputConfigurationSet {
    private List<OutputConfiguration> outputs;

    public OutputConfigurationSet() {
        this.outputs = new ArrayList<>();
    }
}
