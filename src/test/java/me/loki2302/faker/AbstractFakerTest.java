package me.loki2302.faker;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import me.loki2302.faker.Faker;

public abstract class AbstractFakerTest {
    protected Faker faker = Faker.make();
    
    protected static void assertStringNotNullOrEmpty(String s) {
        assertNotNull(s);
        assertNotEquals(0, s.length());
    }
}