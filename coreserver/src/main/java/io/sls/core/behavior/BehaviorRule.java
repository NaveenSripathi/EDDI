package io.sls.core.behavior;

import io.sls.core.behavior.extensions.IExtension;
import io.sls.memory.IConversationMemory;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * User: jarisch
 * Date: 03.08.2009
 * Time: 14:39:16
 */
@Getter
@Setter
public class BehaviorRule implements Cloneable {
    private String name;
    private List<String> actions;
    private List<IExtension> extensions;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public BehaviorRule() {
        actions = new LinkedList<>();
        extensions = new LinkedList<>();
    }

    public BehaviorRule(String name) {
        this.name = name;
        actions = new LinkedList<>();
        extensions = new LinkedList<>();
    }

    public IExtension.ExecutionState execute(IConversationMemory memory, List<BehaviorRule> trace) {
        if (trace.contains(this)) {
            List<BehaviorRule> endlessLoop = trace.subList(trace.indexOf(this), trace.size());
            endlessLoop.add(this);

            logger.error("reached endless loop:");
            for (BehaviorRule status : trace)
                logger.error(" -> " + status.getName());

            return IExtension.ExecutionState.ERROR;
        } else {
            trace.add(this);

            IExtension.ExecutionState state = IExtension.ExecutionState.NOT_EXECUTED;
            for (IExtension extension : extensions) {
                extension.execute(memory, trace);
                if (extension.getExecutionState() == IExtension.ExecutionState.FAIL) {
                    state = IExtension.ExecutionState.FAIL;
                    break;
                } else if (extension.getExecutionState() == IExtension.ExecutionState.ERROR) {
                    state = IExtension.ExecutionState.ERROR;
                    break;
                }
            }

            List<BehaviorRule> tmp = new LinkedList<>(trace);
            trace.clear();
            trace.addAll(tmp.subList(0, tmp.indexOf(this)));

            if (state != IExtension.ExecutionState.NOT_EXECUTED)
                return state;

            return IExtension.ExecutionState.SUCCESS;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BehaviorRule)) return false;

        BehaviorRule that = (BehaviorRule) o;

        return name.equals(that.getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public BehaviorRule clone() throws CloneNotSupportedException {
        BehaviorRule clone = new BehaviorRule(name);

        List<IExtension> executablesClone = new LinkedList<>();
        for (IExtension extension : extensions) {
            IExtension exClone = extension.clone();
            executablesClone.add(exClone);
        }
        clone.setExtensions(executablesClone);

        return clone;
    }

    @Override
    public String toString() {
        return name;
    }
}
