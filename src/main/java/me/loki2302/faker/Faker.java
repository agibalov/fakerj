package me.loki2302.faker;

import java.io.IOException;

import me.loki2302.faker.infrastructure.JavaScriptEvaluator;

public class Faker {
    public final FakerName Name;
    public final FakerAddress Address;
    public final FakerPhoneNumber PhoneNumber;
    public final FakerInternet Internet;
    public final FakerCompany Company;
    public final FakerLorem Lorem;
    public final FakerHelpers Helpers;
    
    private Faker(
            FakerName fakerName,
            FakerAddress fakerAddress,
            FakerPhoneNumber fakerPhoneNumber,
            FakerInternet fakerInternet,
            FakerCompany fakerCompany,
            FakerLorem fakerLorem,
            FakerHelpers fakerHelpers) {
        
        this.Name = fakerName;
        this.Address = fakerAddress;
        this.PhoneNumber = fakerPhoneNumber;
        this.Internet = fakerInternet;
        this.Company = fakerCompany;
        this.Lorem = fakerLorem;
        this.Helpers = fakerHelpers;
    }
    
    public static Faker make() {
        JavaScriptEvaluator javaScriptEvaluator = new JavaScriptEvaluator();
        
        try {
            javaScriptEvaluator.loadScriptFromResource("env.js");
            javaScriptEvaluator.loadScriptFromResource("Faker.js");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }      
        
        FakerName fakerName = new FakerName(javaScriptEvaluator);
        FakerAddress fakerAddress = new FakerAddress(javaScriptEvaluator);
        FakerPhoneNumber fakerPhoneNumber = new FakerPhoneNumber(javaScriptEvaluator);
        FakerInternet fakerInternet = new FakerInternet(javaScriptEvaluator); 
        FakerCompany fakerCompany = new FakerCompany(javaScriptEvaluator); 
        FakerLorem fakerLorem = new FakerLorem(javaScriptEvaluator);
        FakerHelpers fakerHelpers = new FakerHelpers(javaScriptEvaluator);
        
        return new Faker(
                fakerName,
                fakerAddress,
                fakerPhoneNumber,
                fakerInternet,
                fakerCompany,
                fakerLorem,
                fakerHelpers);
    }
}