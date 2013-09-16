package me.loki2302.faker;

import org.junit.Test;

public class InternetTest extends AbstractFakerTest {
    @Test
    public void emailIsOk() {
        assertStringNotNullOrEmpty(faker.Internet.email());
    }
    
    @Test
    public void userNameIsOk() {
        assertStringNotNullOrEmpty(faker.Internet.userName());
    }
    
    @Test
    public void domainNameIsOk() {
        assertStringNotNullOrEmpty(faker.Internet.domainName());
    }
    
    @Test
    public void domainWordIsOk() {
        assertStringNotNullOrEmpty(faker.Internet.domainWord());
    }
    
    @Test
    public void ipIsOk() {
        assertStringNotNullOrEmpty(faker.Internet.ip());
    }
}
