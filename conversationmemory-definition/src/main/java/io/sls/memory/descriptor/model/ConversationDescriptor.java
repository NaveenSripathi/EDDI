package io.sls.memory.descriptor.model;

import io.sls.memory.feedback.model.Feedback;
import io.sls.memory.model.ConversationState;
import io.sls.memory.model.Deployment;
import io.sls.resources.rest.descriptor.model.ResourceDescriptor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

/**
 * User: jarisch
 * Date: 21.11.12
 * Time: 12:25
 */
@Getter
@Setter
public class ConversationDescriptor extends ResourceDescriptor {
    public enum ViewState {
        UNSEEN,
        SEEN
    }

    private String botName;
    private ViewState viewState;
    private int conversationStepSize;
    private String createdByUserName;
    private Deployment.Environment environment;
    private ConversationState conversationState;
    private List<FeedbackPosition> feedbacks;

    public ConversationDescriptor() {
        this.feedbacks = new LinkedList<>();
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class FeedbackPosition {
        private URI feedback;
        private Feedback.Type feedbackType;
        private int conversationStep;

        public FeedbackPosition(URI feedback, int conversationStep) {
            this.feedback = feedback;
            this.conversationStep = conversationStep;
        }
    }
}

