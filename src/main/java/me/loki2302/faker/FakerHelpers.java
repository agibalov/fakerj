package me.loki2302.faker;

import me.loki2302.faker.dto.UserCard;
import me.loki2302.faker.infrastructure.JavaScript;

public interface FakerHelpers {
    // TODO: randomNumber
    // TODO: randomize
    // TODO: slugify
    // TODO: replaceSymbolWithNumber
    // TODO: shuffle
    // TODO: createCard
    
    @JavaScript("window.Faker.Helpers.userCard()")
    UserCard userCard();
}