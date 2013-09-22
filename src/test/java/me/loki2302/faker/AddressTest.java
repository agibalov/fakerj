package me.loki2302.faker;

import org.junit.Test;

public class AddressTest extends AbstractFakerTest {
    @Test
    public void zipCodeIsOk() {
        assertStringNotNullOrEmpty(faker.Address.zipCode());
    }
    
    @Test
    public void zipCodeFormat0IsOk() {
        assertStringNotNullOrEmpty(faker.Address.zipCodeFormat(0));
    }
    
    @Test
    public void zipCodeFormat1IsOk() {
        assertStringNotNullOrEmpty(faker.Address.zipCodeFormat(1));
    }    
    
    @Test
    public void cityIsOk() {
        assertStringNotNullOrEmpty(faker.Address.city());
    }
    
    @Test
    public void streetNameIsOk() {
        assertStringNotNullOrEmpty(faker.Address.streetName());
    }
    
    // TODO: streetAddress
    
    @Test
    public void secondaryAddressIsOk() {
        assertStringNotNullOrEmpty(faker.Address.secondaryAddress());
    }
    
    // TODO: brState
    
    @Test
    public void ukCountyIsOk() {
        assertStringNotNullOrEmpty(faker.Address.ukCounty());
    }
    
    @Test
    public void ukCountryIsOk() {
        assertStringNotNullOrEmpty(faker.Address.ukCountry());
    }
    
    // TODO: usState
    
    @Test
    public void latitudeIsOk() {
        assertLatitudeIsOk(faker.Address.latitude());
    }
    
    @Test
    public void longitudeIsOk() {
        assertLongitudeIsOk(faker.Address.longitude());
    }
}