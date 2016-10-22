package io.sls.resources.rest.behavior.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

/**
 * User: jarisch
 * Date: 10.06.12
 * Time: 21:51
 */
@Getter
@Setter
@JsonIgnoreProperties({"id", "children", "selected", "opened", "editable"})
public class BehaviorGroupConfiguration {
    private String name;
    private List<BehaviorRuleConfiguration> behaviorRules;

    public BehaviorGroupConfiguration() {
        behaviorRules = new LinkedList<>();
    }
}

