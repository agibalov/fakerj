package me.loki2302.faker;

import me.loki2302.faker.infrastructure.JavaScript;

public interface FakerAddress {
    @JavaScript("window.Faker.Address.zipCode()")
    String zipCode();
        
    // TODO: zipCodeFormat
    
    @JavaScript("window.Faker.Address.city()")
    String city();
    
    @JavaScript("window.Faker.Address.streetName()")
    String streetName();
    
    // TODO: streetAddress
    
    @JavaScript("window.Faker.Address.secondaryAddress()")
    String secondaryAddress();
    
    // TODO: brState
    
    @JavaScript("window.Faker.Address.ukCounty()")
    String ukCounty();
    
    @JavaScript("window.Faker.Address.ukCountry()")
    String ukCountry();
    
    // TODO: usState
    
    @JavaScript("window.Faker.Address.latitude()")
    double latitude();
    
    @JavaScript("window.Faker.Address.longitude()")
    double longitude();
}
