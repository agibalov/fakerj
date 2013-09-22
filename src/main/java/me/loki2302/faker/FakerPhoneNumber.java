package me.loki2302.faker;

import me.loki2302.faker.infrastructure.JavaScriptEvaluator;

public class FakerPhoneNumber {
    private final JavaScriptEvaluator javaScriptEvaluator;
    
    public FakerPhoneNumber(JavaScriptEvaluator javaScriptEvaluator) {
        this.javaScriptEvaluator = javaScriptEvaluator;
    }
        
    public String phoneNumber() {
        return javaScriptEvaluator.evaluate("window.Faker.PhoneNumber", "phoneNumber", String.class);
    }
    
    public String phoneNumberFormat(int format) {
        return javaScriptEvaluator.evaluate("window.Faker.PhoneNumber", "phoneNumberFormat", String.class, format);
    }
}