package io.sls.faces.model;

import io.sls.memory.model.Deployment;
import lombok.Getter;
import lombok.Setter;

/**
 * User: jarisch
 * Date: 18.01.13
 * Time: 21:51
 */
@Getter
@Setter
public class Face {
    private Deployment.Environment environment;
    private String botId;
}

