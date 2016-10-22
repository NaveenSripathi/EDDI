package io.sls.resources.rest.behavior.model.extensions;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * User: jarisch
 * Date: 06.08.12
 * Time: 13:16
 */
@Getter
@Setter
public class ExecutableAttributeDescriptor {
    private String name;
    private String type;
    private List<String> possibleValues;
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExecutableAttributeDescriptor that = (ExecutableAttributeDescriptor) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (!name.equals(that.name)) return false;
        if (possibleValues != null ? !possibleValues.equals(that.possibleValues) : that.possibleValues != null)
            return false;
        return type != null ? type.equals(that.type) : that.type == null;

    }

    @Override
    public int hashCode() {
        int result = (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (possibleValues != null ? possibleValues.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
