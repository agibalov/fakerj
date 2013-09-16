package me.loki2302.faker;

import me.loki2302.faker.infrastructure.JavaScript;

public interface FakerInternet {   
    @JavaScript("window.Faker.Internet.email()")
    String email();
    
    // TODO: userName
    // TODO: domainName
    // TODO: domainWord
    // TODO: ip
}