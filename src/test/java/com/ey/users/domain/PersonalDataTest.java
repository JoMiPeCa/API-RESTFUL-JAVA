package com.ey.users.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@ContextConfiguration(classes = {PersonalData.class, Phones.class, SessionData.class})
@WebMvcTest
class PersonalDataTest {

    private PersonalData personalData = populateDefaultPD();

    public static final String NAME_JOHN = "John";
    public static final String NAME_JOSEPH = "Joseph";
    public static final String EMAIL_TEST = "test@test.com";
    public static final String EMAIL_TEST_2 = "test2@test.com";
    public static final String PASSWORD = "Test12";
    public static final String PASSWORD2 = "Tester12";
    public static final String ONETWOTHREE = "123";

    @Test
    void getName() {
        assertEquals(NAME_JOHN,personalData.getName());
    }

    @Test
    void setName() {
        personalData.setName(NAME_JOSEPH);
        assertEquals(NAME_JOSEPH,personalData.getName());
    }

    @Test
    void getEmail() {
        assertEquals(EMAIL_TEST, personalData.getEmail());
    }

    @Test
    void setEmail() {
        personalData.setEmail(EMAIL_TEST_2);
        assertEquals(EMAIL_TEST_2, personalData.getEmail());
    }

    @Test
    void getPassword() {
        assertEquals(PASSWORD, personalData.getPassword());
    }

    @Test
    void setPassword() {
        personalData.setPassword(PASSWORD2);
        assertEquals(PASSWORD2,personalData.getPassword());
    }

    @Test
    void setPhones() {
        Phones phones = new Phones();
        phones.setNumber("12345");
        phones.setCountrycode("123");
        phones.setCitycode("123");
        personalData.setPhones(phones);
        assertEquals(phones, personalData.getPhones());
    }

    @Test
    void setSessionData() {
        SessionData sessionData = new SessionData(EMAIL_TEST);
        personalData.setSessionData(sessionData);
        assertEquals(sessionData, personalData.getSessionData());
    }

    private PersonalData populateDefaultPD(){
        SessionData sessionData = new SessionData(EMAIL_TEST);
        return new PersonalData(NAME_JOHN, EMAIL_TEST, PASSWORD, populateDefaultPhones(), sessionData);
    }

    private Phones populateDefaultPhones(){
        Phones phones = new Phones();
        phones.setNumber("12345678");
        phones.setCitycode(ONETWOTHREE);
        phones.setCountrycode(ONETWOTHREE);
        return phones;
    }
}