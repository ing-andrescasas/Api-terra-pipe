package com.terrapipe.app.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_personal_informations")
public class UserPersonalInformation {
    @Id
    private Integer id;
    private String name;
    private String lastName;
    private String address;
    @Column(name = "phone_number")
    private Integer phoneNumber;
    private boolean status;
    
//    @ManyToOne(fetch = FetchType.LAZY)
//    private TypeId typeId;
//


    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "countries_id")
    //private Country country;

    public UserPersonalInformation() {
    }

    public UserPersonalInformation(Integer id, String name, String lastName, String address, Integer phoneNumber,
            boolean status) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserPersonalInformation [id=" + id + ", name=" + name + ", lastName=" + lastName + ", address="
                + address + ", phoneNumber=" + phoneNumber + ", status=" + status + "]";
    }

    
}
