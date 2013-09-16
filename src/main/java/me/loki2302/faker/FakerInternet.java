package me.loki2302.faker;

import me.loki2302.faker.infrastructure.JavaScript;

public interface FakerInternet {   
    @JavaScript("window.Faker.Internet.email()")
    String email();
    
    @JavaScript("window.Faker.Internet.userName()")
    String userName();    
    
    @JavaScript("window.Faker.Internet.domainName()")
    String domainName();
    
    @JavaScript("window.Faker.Internet.domainWord()")
    String domainWord();
    
    @JavaScript("window.Faker.Internet.ip()")
    String ip();
}