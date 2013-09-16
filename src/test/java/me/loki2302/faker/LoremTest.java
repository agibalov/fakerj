package me.loki2302.faker;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoremTest extends AbstractFakerTest {
    @Test
    public void wordsWithoutNumIsOk() {
        String[] words = faker.Lorem.words();
        assertEquals(3, words.length);
        for(String word : words) {
            assertStringNotNullOrEmpty(word);
        }
    }
    
    @Test
    public void wordsWithNumIsOk() {
        String[] words = faker.Lorem.words(7);
        assertEquals(7, words.length);
        for(String word : words) {
            assertStringNotNullOrEmpty(word);
        }
    }
    
    @Test
    public void sentenceWithNoParametersIsOk() {
        assertStringNotNullOrEmpty(faker.Lorem.sentence());
    }
    
    @Test
    public void sentenceWithWordCountIsOk() {
        assertStringNotNullOrEmpty(faker.Lorem.sentence(3));
    }
    
    @Test
    public void sentenceWithWordCountAndRangeIsOk() {
        assertStringNotNullOrEmpty(faker.Lorem.sentence(3, 1));
    }
    
    @Test
    public void sentencesWithoutSentenceCountIsOk() {
        assertStringNotNullOrEmpty(faker.Lorem.sentences());
    }
    
    @Test
    public void sentencesWithSentenceCountIsOk() {
        assertStringNotNullOrEmpty(faker.Lorem.sentences(7));
    }
    
    @Test
    public void paragraphWithoutSencenceCountIsOk() {
        assertStringNotNullOrEmpty(faker.Lorem.paragraph());
    }
    
    @Test
    public void paragraphWithSencenceCountIsOk() {
        assertStringNotNullOrEmpty(faker.Lorem.paragraph(7));
    }
    
    @Test
    public void paragraphsWithoutParagraphCountIsOk() {
        assertStringNotNullOrEmpty(faker.Lorem.paragraphs());
    }
    
    @Test
    public void paragraphsWithParagraphCountIsOk() {
        assertStringNotNullOrEmpty(faker.Lorem.paragraphs(7));
    }
}