package me.loki2302.faker.dto;

import me.loki2302.faker.utils.JsonUtils;

public class UserCard {
    public String name;
    public String username;
    public String email;
    public UserCardAddress address;
    public String phone;
    public String website;
    public UserCardCompany company;
    
    @Override
    public String toString() {
        return String.format("UserCard %s", JsonUtils.json(this));
    }
}