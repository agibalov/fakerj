package me.loki2302;

import me.loki2302.faker.Faker;

public class Playground {    
    public static void main(String[] args) {
        Faker faker = Faker.make();
        
        System.out.println(faker.Name.firstName());
        System.out.println(faker.Name.lastName());
        System.out.println(faker.Name.findName());
    }
}
