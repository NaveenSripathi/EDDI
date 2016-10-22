package io.sls.resources.rest.regulardictionary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: jarisch
 * Date: 04.06.12
 * Time: 20:18
 */
@Getter
public class RegularDictionaryConfiguration {
    private String language;
    private List<WordConfiguration> words;
    private List<PhraseConfiguration> phrases;

    public RegularDictionaryConfiguration() {
        this.words = new ArrayList<>();
        this.phrases = new ArrayList<>();
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    @Getter
    @Setter
    @JsonIgnoreProperties({"auto_generate_expression", "auto_to_lower"})
    public static class WordConfiguration {
        private String word;
        private String exp;
        private int frequency;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            WordConfiguration that = (WordConfiguration) o;

            return word.equals(that.word);
        }

        @Override
        public int hashCode() {
            return word.hashCode();
        }
    }

    @JsonIgnoreProperties({"auto_generate_expression", "auto_to_lower"})
    @Getter
    @Setter
    public static class PhraseConfiguration {
        protected String phrase;
        protected String exp;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PhraseConfiguration that = (PhraseConfiguration) o;

            return phrase.equals(that.phrase);
        }

        @Override
        public int hashCode() {
            return phrase.hashCode();
        }
    }
}
