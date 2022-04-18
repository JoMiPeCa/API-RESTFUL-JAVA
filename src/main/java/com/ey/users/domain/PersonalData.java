package com.ey.users.domain;

import javax.persistence.*;

@Entity
@Table(name="personalData")
public class PersonalData {

    @Column(nullable = false, length = 100)
    private String name;

    @Id
    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "number")
    private Phones phones;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private SessionData sessionData;

    public PersonalData(String name, String email, String password, Phones phones, SessionData sessionData) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
        this.sessionData = sessionData;
    }

    public PersonalData() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Phones getPhones() {
        return phones;
    }

    public void setPhones(Phones phones) {
        this.phones = phones;
    }

    public SessionData getSessionData() {
        return sessionData;
    }

    public void setSessionData(SessionData sessionData) {
        this.sessionData = sessionData;
    }
}
