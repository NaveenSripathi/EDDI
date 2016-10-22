package io.sls.memory.feedback.model;

import lombok.Getter;
import lombok.Setter;

/**
 * User: jarisch
 * Date: 19.11.12
 * Time: 11:04
 */
@Getter
@Setter
public class Feedback {
    public enum Type {
        ANSWER_REQUEST,
        FEEDBACK,
        ERROR
    }

    private Type type;
    private String message;
    private ContactDetails contactDetails;

    @Getter
    @Setter
    public static class ContactDetails {
        private String name;
        private String email;
    }
}
