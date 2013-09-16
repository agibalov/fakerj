package me.loki2302.faker;

import me.loki2302.faker.infrastructure.JavaScriptEvaluator;

public class FakerInternet {   
    private final JavaScriptEvaluator javaScriptEvaluator;
    
    public FakerInternet(JavaScriptEvaluator javaScriptEvaluator) {
        this.javaScriptEvaluator = javaScriptEvaluator;
    }
    
    public String email() {
        return javaScriptEvaluator.evaluate("window.Faker.Internet", "email", String.class);
    }
    
    public String userName() {
        return javaScriptEvaluator.evaluate("window.Faker.Internet", "userName", String.class);
    }    
    
    public String domainName() {
        return javaScriptEvaluator.evaluate("window.Faker.Internet", "domainName", String.class);
    }
    
    public String domainWord() {
        return javaScriptEvaluator.evaluate("window.Faker.Internet", "domainWord", String.class);
    }
    
    public String ip() {
        return javaScriptEvaluator.evaluate("window.Faker.Internet", "ip", String.class);
    }
}