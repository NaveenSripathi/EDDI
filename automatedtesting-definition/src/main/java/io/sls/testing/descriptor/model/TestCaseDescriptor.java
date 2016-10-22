package io.sls.testing.descriptor.model;

import io.sls.resources.rest.documentdescriptor.model.DocumentDescriptor;
import io.sls.testing.model.TestCaseState;
import lombok.Getter;
import lombok.Setter;

/**
 * User: jarisch
 * Date: 22.11.12
 * Time: 14:37
 */
@Getter
@Setter
public class TestCaseDescriptor extends DocumentDescriptor {
    private TestCaseState testCaseState;
}
