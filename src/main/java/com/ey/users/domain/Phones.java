package com.ey.users.domain;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "phones")
public class Phones {

    @Id
    @Column(name = "number", nullable = false, length = 100)
    private String number;

    @Column(nullable = false, length = 3)
    private String citycode;

    @Column(nullable = false, length = 3)
    private String countrycode;

    @OneToOne(mappedBy = "phones")
    private PersonalData personalData;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

}
