package com.example.test_login_react.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    private Integer id;
    private String name;
    private String dateOfBirth;
    private String nationalIdNo;
    private String phoneNo;
    private String password;
    private String address;
    private String drivingLicense;
    private float wallet;
    private String email;
    private String createdAt;
    private String modifiedAt;
    private String role;

    public User() {
    }

    public User(int id, String name, String dateOfBirth, String nationalIdNo, String phoneNo, String password, String address, String drivingLicense, float wallet, String email, String createdAt, String modifiedAt, String role) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nationalIdNo = nationalIdNo;
        this.phoneNo = phoneNo;
        this.password = password;
        this.address = address;
        this.drivingLicense = drivingLicense;
        this.wallet = wallet;
        this.email = email;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationalIdNo() {
        return nationalIdNo;
    }

    public void setNationalIdNo(String nationalIdNo) {
        this.nationalIdNo = nationalIdNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
