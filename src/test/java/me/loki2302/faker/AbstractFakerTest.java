package me.loki2302.faker;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import me.loki2302.faker.Faker;

public abstract class AbstractFakerTest {
    protected Faker faker = Faker.make();
    
    protected static void assertStringNotNullOrEmpty(String s) {
        assertNotNull(s);
        assertNotEquals(0, s.length());
    }
    
    protected static void assertLatitudeIsOk(double latitude) {
        assertTrue(latitude >= -90.0);
        assertTrue(latitude <= 90.0);
    }
    
    protected static void assertLongitudeIsOk(double longitude) {
        assertTrue(longitude >= -180.0);
        assertTrue(longitude <= 180.0);
    }
}