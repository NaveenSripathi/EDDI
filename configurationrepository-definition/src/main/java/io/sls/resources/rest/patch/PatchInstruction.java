package io.sls.resources.rest.patch;

import lombok.Getter;
import lombok.Setter;

/**
 * User: jarisch
 * Date: 15.08.12
 * Time: 11:17
 */
@Getter
@Setter
public class PatchInstruction<T> {
    public enum PatchOperation {
        SET,
        DELETE
    }

    private PatchOperation operation;
    private T document;
}
