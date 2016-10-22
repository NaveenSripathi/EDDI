package io.sls.resources.rest.behavior.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: Michael
 * Date: 24.03.12
 * Time: 18:37
 */
@Getter
@Setter
@JsonIgnoreProperties({"default", "id", "producesOutput", "selected", "sequenceNumber", "opened"})
public class BehaviorRuleConfiguration {
    private String name;
    private List<String> actions;
    private List<BehaviorRuleElementConfiguration> children;

    public BehaviorRuleConfiguration() {
        actions = new LinkedList<>();
        children = new ArrayList<>();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BehaviorRuleConfiguration that = (BehaviorRuleConfiguration) o;

        if (actions != null ? !actions.equals(that.actions) : that.actions != null) return false;
        if (children != null ? !children.equals(that.children) : that.children != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (actions != null ? actions.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }
}
