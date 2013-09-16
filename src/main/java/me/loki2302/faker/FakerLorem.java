package me.loki2302.faker;

import me.loki2302.faker.infrastructure.JavaScriptEvaluator;

public class FakerLorem {
    private final JavaScriptEvaluator javaScriptEvaluator;
    
    public FakerLorem(JavaScriptEvaluator javaScriptEvaluator) {
        this.javaScriptEvaluator = javaScriptEvaluator;
    }
    
    public String[] words() {
        return javaScriptEvaluator.evaluate("window.Faker.Lorem", "words", (new String[]{}).getClass());
    }
    
    public String[] words(int num) {
        return javaScriptEvaluator.evaluate("window.Faker.Lorem", "words", (new String[]{}).getClass(), num);
    }
    
    public String sentence() {
        return javaScriptEvaluator.evaluate("window.Faker.Lorem", "sentence", String.class);
    }
    
    public String sentence(int wordCount) {
        return javaScriptEvaluator.evaluate("window.Faker.Lorem", "sentence", String.class, wordCount);
    }
    
    public String sentence(int wordCount, int range) {
        return javaScriptEvaluator.evaluate("window.Faker.Lorem", "sentence", String.class, wordCount, range);
    }
    
    public String sentences() {
        return javaScriptEvaluator.evaluate("window.Faker.Lorem", "sentences", String.class);
    }
    
    public String sentences(int sentenceCount) {
        return javaScriptEvaluator.evaluate("window.Faker.Lorem", "sentences", String.class, sentenceCount);
    }
    
    public String paragraph() {
        return javaScriptEvaluator.evaluate("window.Faker.Lorem", "paragraph", String.class);
    }
    
    public String paragraph(int sentenceCount) {
        return javaScriptEvaluator.evaluate("window.Faker.Lorem", "paragraph", String.class, sentenceCount);
    }
    
    public String paragraphs() {
        return javaScriptEvaluator.evaluate("window.Faker.Lorem", "paragraphs", String.class);
    }
    
    public String paragraphs(int paragraphCount) {
        return javaScriptEvaluator.evaluate("window.Faker.Lorem", "paragraphs", String.class, paragraphCount);
    }
}