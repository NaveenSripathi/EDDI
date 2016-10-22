package io.sls.core.behavior;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

/**
 * User: jarisch
 * Date: 04.08.2009
 * Time: 14:12:33
 */
@Getter
@Setter
@NoArgsConstructor
public class BehaviorSet {
    private List<BehaviorGroup> behaviorGroups = new LinkedList<BehaviorGroup>();

    public List<BehaviorRule> getBehaviorRule(String behaviorRule) {
        List<BehaviorRule> ret = new LinkedList<BehaviorRule>();
        for (BehaviorGroup behaviorGroup : behaviorGroups) {
            for (BehaviorRule status : behaviorGroup.getBehaviorRules()) {
                if (status.getName().equals(behaviorRule)) {
                    ret.add(status);
                }
            }
        }

        return ret;
    }
}