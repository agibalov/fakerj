package me.loki2302.faker;

import org.junit.Test;

public class CompanyTest extends AbstractFakerTest {
    
    // TODO: suffixes
    
    @Test
    public void companyNameIsOk() {
        assertStringNotNullOrEmpty(faker.Company.companyName());
    }
    
    @Test
    public void companyName0IsOk() {
        assertStringNotNullOrEmpty(faker.Company.companyName(0));
    }
    
    @Test
    public void companyName1IsOk() {
        assertStringNotNullOrEmpty(faker.Company.companyName(1));
    }
    
    @Test
    public void companyName2IsOk() {
        assertStringNotNullOrEmpty(faker.Company.companyName(2));
    }
    
    // TODO: companySuffix
    
    // TODO: catchPhrase
    
    // TODO: bs
    
}
