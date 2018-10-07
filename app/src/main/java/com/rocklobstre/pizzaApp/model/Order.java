package com.rocklobstre.pizzaApp.model;


import android.widget.EditText;

import java.io.Serializable;

public class Order implements Serializable {

    private int name;
    private int size;
    private int ing1,ing2,ing3,ing4,ing5,ing6;
    private String  fullName;
    private String address;
    private String postalCode;
    private String telephoneNumber;
    private String paymentInformation;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getPaymentInformation() {
        return paymentInformation;
    }

    public void setPaymentInformation(String paymentInformation) {
        this.paymentInformation = paymentInformation;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getIng1() {
        return ing1;
    }

    public void setIng1(int ing1) {
        this.ing1 = ing1;
    }

    public int getIng2() {
        return ing2;
    }

    public void setIng2(int ing2) {
        this.ing2 = ing2;
    }

    public int getIng3() {
        return ing3;
    }

    public void setIng3(int ing3) {
        this.ing3 = ing3;
    }

    public int getIng4() {
        return ing4;
    }

    public void setIng4(int ing4) {
        this.ing4 = ing4;
    }

    public int getIng5() {
        return ing5;
    }

    public void setIng5(int ing5) {
        this.ing5 = ing5;
    }

    public int getIng6() {
        return ing6;
    }

    public void setIng6(int ing6) {
        this.ing6 = ing6;
    }
}
