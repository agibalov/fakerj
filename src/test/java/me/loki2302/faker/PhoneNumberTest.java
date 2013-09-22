package me.loki2302.faker;

import org.junit.Test;

public class PhoneNumberTest extends AbstractFakerTest {
    @Test
    public void phoneNumberIsOk() {
        assertStringNotNullOrEmpty(faker.PhoneNumber.phoneNumber());
    }
    
    @Test
    public void phoneNumberFormatIsOk() {
        for(int i = 0; i < 20; ++i) {
            assertStringNotNullOrEmpty(faker.PhoneNumber.phoneNumberFormat(i));
        }
    }    
}