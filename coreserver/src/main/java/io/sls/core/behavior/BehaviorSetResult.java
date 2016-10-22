package io.sls.core.behavior;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

/**
 * User: jarisch
 * Date: 09.06.12
 * Time: 16:21
 */
@Getter
@Setter
public class BehaviorSetResult {
    private List<BehaviorRule> successRules;
    private List<BehaviorRule> droppedSuccessRules;
    private List<BehaviorRule> failRules;

    public BehaviorSetResult() {
        successRules = new LinkedList<>();
        droppedSuccessRules = new LinkedList<>();
        failRules = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "BehaviorSetResult{" +
                "successRules=" + successRules +
                ", droppedSuccessRules=" + droppedSuccessRules +
                ", failRules=" + failRules +
                '}';
    }
}
