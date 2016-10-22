package io.sls.core.parser.model;

import io.sls.expressions.Expression;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * User: jarisch
 * Date: 25.01.13
 * Time: 17:14
 */
@Getter
@Setter
public class FoundDictionaryEntry extends DictionaryEntry {
    protected boolean isCorrected = false;
    // 0.0 > and <= 1.0
    protected double matchingAccuracy;

    public FoundDictionaryEntry(String unknownValue, List<Expression> expressions, boolean corrected, double matchingAccuracy) {
        super(unknownValue, expressions);
    }

    public FoundDictionaryEntry(IDictionary.IDictionaryEntry dictionaryEntry, boolean corrected, double matchingAccuracy) {
        super(dictionaryEntry.getValue(), dictionaryEntry.getExpressions());
        isCorrected = corrected;
        this.matchingAccuracy = matchingAccuracy;
    }
}
