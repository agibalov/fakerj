package me.loki2302.faker;

import static org.junit.Assert.*;
import me.loki2302.faker.dto.UserCard;
import me.loki2302.faker.dto.UserCardAddress;
import me.loki2302.faker.dto.UserCardAddressGeo;
import me.loki2302.faker.dto.UserCardCompany;

import org.junit.Test;

public class HelpersTest extends AbstractFakerTest {
    @Test
    public void userCardIsOk() {
        UserCard userCard = faker.Helpers.userCard();
        assertUserCardIsOk(userCard);
    }
    
    private static void assertUserCardIsOk(UserCard userCard) {
        assertStringNotNullOrEmpty(userCard.name);
        assertStringNotNullOrEmpty(userCard.username);
        assertStringNotNullOrEmpty(userCard.email);
        assertUserCardAddressIsOk(userCard.address);
        assertStringNotNullOrEmpty(userCard.phone);
        assertStringNotNullOrEmpty(userCard.website);
        assertStringNotNullOrEmpty(userCard.phone);
        assertUserCardCompanyIsOk(userCard.company);
    }
    
    private static void assertUserCardAddressIsOk(UserCardAddress userCardAddress) {
        assertStringNotNullOrEmpty(userCardAddress.street);
        assertStringNotNullOrEmpty(userCardAddress.suite);
        assertStringNotNullOrEmpty(userCardAddress.city);
        assertStringNotNullOrEmpty(userCardAddress.zipcode);
        assertUserCardAddressGeoIsOk(userCardAddress.geo);
    }
    
    private static void assertUserCardCompanyIsOk(UserCardCompany userCardCompany) {
        assertStringNotNullOrEmpty(userCardCompany.name);
        assertStringNotNullOrEmpty(userCardCompany.catchPhrase);
        assertStringNotNullOrEmpty(userCardCompany.bs);
    }
    
    private static void assertUserCardAddressGeoIsOk(UserCardAddressGeo userCardAddressGeo) {
        assertTrue(userCardAddressGeo.lat >= -90.0);
        assertTrue(userCardAddressGeo.lat <= 90.0);
        assertTrue(userCardAddressGeo.lng >= -180.0);
        assertTrue(userCardAddressGeo.lng <= 180.0);
    }
}