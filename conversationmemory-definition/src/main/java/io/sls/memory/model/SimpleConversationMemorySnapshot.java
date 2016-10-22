package io.sls.memory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * User: jarisch
 * Date: 15.11.12
 * Time: 16:42
 */
@Getter
@Setter
public class SimpleConversationMemorySnapshot {
    private String botId;
    private Integer botVersion;
    private List<SimpleConversationStep> conversationSteps;

    private Deployment.Environment environment;
    private ConversationState conversationState;
    private int redoCacheSize;


    public SimpleConversationMemorySnapshot() {
        this.conversationSteps = new LinkedList<>();
    }

    @Getter
    @Setter
    public static class SimpleConversationStep {
        private List<SimpleData> data;
        private Date timestamp;

        public SimpleConversationStep() {
            this.data = new LinkedList<>();
        }
    }


    @Getter
    @Setter
    @AllArgsConstructor
    public static class SimpleData {
        private String key;
        private String value;

        private SimpleData() {
        }
    }
}
