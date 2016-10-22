package io.sls.resources.rest.behavior.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

/**
 * User: Michael
 * Date: 24.03.12
 * Time: 18:36
 */
@Getter
@Setter
public class BehaviorConfiguration {
    private List<BehaviorGroupConfiguration> behaviorGroups;

    public BehaviorConfiguration() {
        behaviorGroups = new LinkedList<>();
    }
}
