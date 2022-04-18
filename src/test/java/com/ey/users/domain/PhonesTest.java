package com.ey.users.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhonesTest {

    public static final String ONETWOTHREE = "123";
    public static final String ONETOEIGHT = "12345678";
    private Phones phones = populateDefaultPhones();

    @Test
    void getNumber() {
        assertEquals(ONETOEIGHT,phones.getNumber());
    }

    @Test
    void getCitycode() {
        assertEquals(ONETWOTHREE, phones.getCitycode());
    }

    @Test
    void getCountrycode() {
        assertEquals(ONETWOTHREE,phones.getCountrycode());
    }

    private Phones populateDefaultPhones(){
        Phones phones = new Phones();
        phones.setNumber(ONETOEIGHT);
        phones.setCitycode(ONETWOTHREE);
        phones.setCountrycode(ONETWOTHREE);
        return phones;
    }
}