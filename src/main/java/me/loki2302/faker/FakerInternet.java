package me.loki2302.faker;

import me.loki2302.faker.infrastructure.JavaScript;

public interface FakerInternet {
    // TODO
    
    @JavaScript("window.Faker.Internet.email()")
    String email();
}