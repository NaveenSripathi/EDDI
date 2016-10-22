package io.sls.resources.rest.behavior.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * User: Michael
 * Date: 01.04.12
 * Time: 15:45
 */
@Getter
@JsonIgnoreProperties({"id", "behaviorRules", "editable", "opened", "name", "selected"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BehaviorRuleElementConfiguration {
    private String type;
    private Map<String, String> values;
    private List<BehaviorRuleElementConfiguration> children;

    public BehaviorRuleElementConfiguration() {
        values = new HashMap<>();
        children = new LinkedList<>();
    }

    public void setType(String type) {
        this.type = type;
    }
}
