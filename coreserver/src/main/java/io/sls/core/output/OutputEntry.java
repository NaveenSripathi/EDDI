package io.sls.core.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User: jarisch
 * Date: 12.03.12
 * Time: 16:35
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OutputEntry implements Comparable<OutputEntry> {
    private String key;
    private String text;
    private int occurrence;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OutputEntry that = (OutputEntry) o;

        if (occurrence != that.occurrence) return false;
        if (!key.equals(that.key)) return false;
        return text.equals(that.text);

    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + occurrence;
        return result;
    }

    @Override
    public int compareTo(OutputEntry o) {
        return occurrence < o.getOccurrence() ? -1 : (occurrence == o.getOccurrence() ? 0 : 1);
    }

    @Override
    public String toString() {
        return "{" +
                "\"key\"=\"" + key + "\"" +
                ", \"text\"=\"" + text + "\"" +
                ", \"occurrence\"=\"" + occurrence + "\"" +
                "}";
    }
}
