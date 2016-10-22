package io.sls.resources.rest.bots.model;


import lombok.Getter;
import lombok.Setter;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * User: jarisch
 * Date: 20.05.12
 * Time: 19:41
 */
@Getter
@Setter
public class BotConfiguration {
    private boolean authenticationRequired;
    private List<URI> packages;

    public BotConfiguration() {
        authenticationRequired = true;
        this.packages = new ArrayList<>();
    }
}
