package com.ey.users.domain;

import com.ey.users.utilities.Helper;

import javax.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "session_data")
public class SessionData extends Helper {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(nullable = false, updatable = false)
    private Date dateCreated;

    @Column
    private Date dateModified;

    @Column
    private Date lastLogin;

    @Column
    private String token;

    @Column(nullable = false)
    private boolean isactive;

    @OneToOne(mappedBy = "sessionData")
    private PersonalData personalData;

    public SessionData(String email) {
        this.id = UUID.randomUUID();
        setDateCreated();
        setDateModified();
        setLastLogin(getDateCreated());
        setToken(getJWTToken(email));
        setIsactive(true);
    }

    public SessionData() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated() {
        this.dateCreated = Date.valueOf(LocalDate.now());
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified() {
        this.dateModified = Date.valueOf(LocalDate.now());
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }
}
