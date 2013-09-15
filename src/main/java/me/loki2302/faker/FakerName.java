package me.loki2302.faker;

import me.loki2302.faker.infrastructure.JavaScript;

public interface FakerName {
    @JavaScript("window.Faker.Name.firstName()")
    String firstName();
    
    @JavaScript("window.Faker.Name.lastName()")
    String lastName();
    
    @JavaScript("window.Faker.Name.findName()")
    String findName();
}