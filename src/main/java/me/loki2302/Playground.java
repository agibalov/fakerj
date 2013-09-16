package me.loki2302;

import java.io.IOException;
import java.util.List;

import me.loki2302.faker.Faker;
import me.loki2302.faker.infrastructure.JavaScriptEvaluator;

public class Playground {    
    public static void main(String[] args) {
        JavaScriptEvaluator javaScriptEvaluator = new JavaScriptEvaluator();
        
        try {
            javaScriptEvaluator.loadScriptFromResource("env.js");
            javaScriptEvaluator.loadScriptFromResource("Faker.js");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        
        //String[] words = javaScriptEvaluator.words(7);
        String[] words = javaScriptEvaluator.evaluate("window.Faker.Lorem", "words", (new String[]{}).getClass(), 7);
        for(String word : words) {
            System.out.println(word);
        }
        
        System.out.println(javaScriptEvaluator.evaluate("window.Faker.Name", "findName", String.class));
    }
}
