package me.loki2302.faker;

import me.loki2302.faker.infrastructure.JavaScriptEvaluator;

public class FakerName {
    private final JavaScriptEvaluator javaScriptEvaluator;
    
    public FakerName(JavaScriptEvaluator javaScriptEvaluator) {
        this.javaScriptEvaluator = javaScriptEvaluator;
    }
    
    public String firstName() {
        return javaScriptEvaluator.evaluate("window.Faker.Name", "firstName", String.class);
    }
    
    public String lastName() {
        return javaScriptEvaluator.evaluate("window.Faker.Name", "lastName", String.class);
    }
        
    public String findName() {
        return javaScriptEvaluator.evaluate("window.Faker.Name", "findName", String.class);
    }
}