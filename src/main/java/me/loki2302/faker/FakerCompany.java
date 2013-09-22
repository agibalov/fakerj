package me.loki2302.faker;

import me.loki2302.faker.infrastructure.JavaScriptEvaluator;

public class FakerCompany {
    private final JavaScriptEvaluator javaScriptEvaluator;
    
    public FakerCompany(JavaScriptEvaluator javaScriptEvaluator) {
        this.javaScriptEvaluator = javaScriptEvaluator;
    }
    
    // TODO: suffixes
    
    public String companyName() {
        return javaScriptEvaluator.evaluate("window.Faker.Company", "companyName", String.class);
    }
    
    public String companyName(int format) {
        return javaScriptEvaluator.evaluate("window.Faker.Company", "companyName", String.class, format);
    }
    
    // TODO: companySuffix
    // TODO: catchPhrase
    // TODO: bs
}