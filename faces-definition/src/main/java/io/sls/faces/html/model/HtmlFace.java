package io.sls.faces.html.model;

import io.sls.faces.model.Face;
import lombok.Getter;
import lombok.Setter;

/**
 * User: jarisch
 * Date: 18.01.13
 * Time: 21:52
 */
@Getter
@Setter
public class HtmlFace extends Face {
    private String host;
    private String uiLanguage;
    private String uiLocation;
    private String uiIdentifier;
}
