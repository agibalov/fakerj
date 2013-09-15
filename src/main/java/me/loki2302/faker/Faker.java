package me.loki2302.faker;

import java.io.IOException;

import me.loki2302.faker.infrastructure.JavaScriptEvaluator;
import me.loki2302.faker.infrastructure.JavaScriptImplementor;

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
        
        JavaScriptImplementor javaScriptImplementor = new JavaScriptImplementor(javaScriptEvaluator);        
        
        FakerName fakerName = javaScriptImplementor.implement(FakerName.class);
        FakerAddress fakerAddress = javaScriptImplementor.implement(FakerAddress.class);
        FakerPhoneNumber fakerPhoneNumber = javaScriptImplementor.implement(FakerPhoneNumber.class);
        FakerInternet fakerInternet = javaScriptImplementor.implement(FakerInternet.class);
        FakerCompany fakerCompany = javaScriptImplementor.implement(FakerCompany.class);
        FakerLorem fakerLorem = javaScriptImplementor.implement(FakerLorem.class);
        FakerHelpers fakerHelpers = javaScriptImplementor.implement(FakerHelpers.class);
        
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