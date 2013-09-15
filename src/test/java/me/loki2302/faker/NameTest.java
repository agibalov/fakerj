package me.loki2302.faker;

import org.junit.Test;

public class NameTest extends AbstractFakerTest {    
    @Test
    public void firstNameIsOk() {
        assertStringNotNullOrEmpty(faker.Name.firstName());
    }
    
    @Test
    public void lastNameIsOk() {
        assertStringNotNullOrEmpty(faker.Name.lastName());
    }
    
    @Test
    public void findNameIsOk() {
        assertStringNotNullOrEmpty(faker.Name.findName());
    }
}