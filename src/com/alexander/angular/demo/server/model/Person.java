package com.alexander.angular.demo.server.model;

/**
 * Created with IntelliJ IDEA.
 * User: Alexander
 * Date: 21.08.13
 * Time: 11:10
 * To change this template use File | Settings | File Templates.
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.googlecode.objectify.annotation.Indexed;
import com.googlecode.objectify.annotation.Unindexed;

@Entity
public class Person {

    @Id
    private Long id;

    @Unindexed
    private Integer version;

    @Indexed
    private String firstName;

    @Indexed
    private String lastName;

    @Indexed
    private String ssn;

    @Indexed
    private String gender;

    @Indexed
    private String dateOfBirth;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @PrePersist
    public void updateVersion() {
        if (version == null) {
            version = Integer.valueOf(0);
        }
        version++;
    }
}
