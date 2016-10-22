package io.sls.core.behavior;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

/**
 * User: jarisch
 * Date: 16.11.2010
 * Time: 23:10:51
 */
@Getter
@Setter
public class BehaviorGroup {
    private String name;
    private List<BehaviorRule> behaviorRules;

    public BehaviorGroup() {
        behaviorRules = new LinkedList<>();
    }
}
