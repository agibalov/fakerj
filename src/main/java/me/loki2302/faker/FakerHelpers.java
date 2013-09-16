package me.loki2302.faker;

import me.loki2302.faker.dto.UserCard;
import me.loki2302.faker.infrastructure.JavaScriptEvaluator;

public class FakerHelpers {
    private final JavaScriptEvaluator javaScriptEvaluator;
    
    public FakerHelpers(JavaScriptEvaluator javaScriptEvaluator) {
        this.javaScriptEvaluator = javaScriptEvaluator;
    }
    
    // TODO: randomNumber
    // TODO: randomize
    // TODO: slugify
    // TODO: replaceSymbolWithNumber
    // TODO: shuffle
    // TODO: createCard
        
    public UserCard userCard() {
        return javaScriptEvaluator.evaluateAsDto("window.Faker.Helpers", "userCard", UserCard.class);
    }
}