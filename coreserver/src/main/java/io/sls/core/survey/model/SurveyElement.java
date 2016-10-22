package io.sls.core.survey.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SurveyElement {

    private String name;
    private String[] propertyExpressions;
    private String[] categoryExpressions;
    private String outputId;

    private Float randomFactor;
    private SortingType sortingType;
    private Integer showMax;
    private Integer showMin;
    private Integer rounds;
    private Boolean surveyChildZeroResults;
    private Boolean surveyChildUnchangedResults;
    private List<SurveyElement> children = new ArrayList<SurveyElement>();

    public SurveyElement(float randomFactor, SortingType sortingType, int showMax, int showMin, int rounds,
                         boolean surveyChildZeroResults, boolean surveyChildUnchangedResults) {
        this.randomFactor = randomFactor;
        this.sortingType = sortingType;
        this.showMax = showMax;
        this.showMin = showMin;
        this.rounds = rounds;
        this.surveyChildZeroResults = surveyChildZeroResults;
        this.surveyChildUnchangedResults = surveyChildUnchangedResults;
    }

    public enum SortingType {
        alphabetic, resultsize, orderId
    }
}
