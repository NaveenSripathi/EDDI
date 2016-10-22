package io.sls.memory.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * User: jarisch
 * Date: 23.08.12
 * Time: 15:03
 */
@Getter
@Setter
public class ConversationMemorySnapshot {
    private String id;
    private String botId;
    private Integer botVersion;

    private Deployment.Environment environment;
    private ConversationState conversationState;

    private List<ConversationStepSnapshot> conversationSteps;
    private Stack<ConversationStepSnapshot> redoCache;

    public ConversationMemorySnapshot() {
        this.conversationSteps = new LinkedList<>();
        this.redoCache = new Stack<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConversationMemorySnapshot that = (ConversationMemorySnapshot) o;

        return conversationSteps != null ? conversationSteps.equals(that.conversationSteps) : that.conversationSteps == null;

    }

    @Override
    public int hashCode() {
        return conversationSteps != null ? conversationSteps.hashCode() : 0;
    }

    @Getter
    @Setter
    public static class ConversationStepSnapshot {
        private List<PackageRunSnapshot> packages;

        public ConversationStepSnapshot() {
            this.packages = new LinkedList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ConversationStepSnapshot that = (ConversationStepSnapshot) o;

            return packages != null ? packages.equals(that.packages) : that.packages == null;

        }

        @Override
        public int hashCode() {
            return packages != null ? packages.hashCode() : 0;
        }
    }

    @Getter
    @Setter
    public static class PackageRunSnapshot {
        private String context;
        private List<ResultSnapshot> lifecycleTasks;

        public PackageRunSnapshot() {
            this.lifecycleTasks = new LinkedList<>();
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PackageRunSnapshot that = (PackageRunSnapshot) o;

            if (context != null ? !context.equals(that.context) : that.context != null) return false;
            return lifecycleTasks != null ? lifecycleTasks.equals(that.lifecycleTasks) : that.lifecycleTasks == null;

        }

        @Override
        public int hashCode() {
            int result = context != null ? context.hashCode() : 0;
            result = 31 * result + (lifecycleTasks != null ? lifecycleTasks.hashCode() : 0);
            return result;
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResultSnapshot {
        private String key;
        private Object result;
        private List possibleResults;
        private Date timestamp;
        private boolean isPublic;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ResultSnapshot that = (ResultSnapshot) o;

            if (key != null ? !key.equals(that.key) : that.key != null) return false;
            return possibleResults != null ? possibleResults.equals(that.possibleResults) : that.possibleResults == null;

        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (possibleResults != null ? possibleResults.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("{lifecycleTasks=").append(result).append('}');
            return sb.toString();
        }
    }
}
