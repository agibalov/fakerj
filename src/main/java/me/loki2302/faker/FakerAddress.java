package me.loki2302.faker;

import me.loki2302.faker.infrastructure.JavaScriptEvaluator;

public class FakerAddress {    
    private final JavaScriptEvaluator javaScriptEvaluator;
    
    public FakerAddress(JavaScriptEvaluator javaScriptEvaluator) {
        this.javaScriptEvaluator = javaScriptEvaluator;
    }
    
    public String zipCode() {
        return javaScriptEvaluator.evaluate("window.Faker.Address", "zipCode", String.class);
    }
    
    public String zipCodeFormat(int format) {
        return javaScriptEvaluator.evaluate("window.Faker.Address", "zipCode", String.class, format);
    }
    
    public String city() {
        return javaScriptEvaluator.evaluate("window.Faker.Address", "city", String.class);
    }
    
    public String streetName() {
        return javaScriptEvaluator.evaluate("window.Faker.Address", "streetName", String.class);
    }
    
    // TODO: streetAddress
        
    public String secondaryAddress() {
        return javaScriptEvaluator.evaluate("window.Faker.Address", "secondaryAddress", String.class);
    }
    
    // TODO: brState
        
    public String ukCounty() {
        return javaScriptEvaluator.evaluate("window.Faker.Address", "ukCounty", String.class);
    }
        
    public String ukCountry() {
        return javaScriptEvaluator.evaluate("window.Faker.Address", "ukCountry", String.class);
    }
    
    // TODO: usState
    
    public double latitude() {
        return javaScriptEvaluator.evaluate("window.Faker.Address", "latitude", Double.class);
    }
    
    public double longitude() {
        return javaScriptEvaluator.evaluate("window.Faker.Address", "longitude", Double.class);
    }
}
