package com.bloodlink.model;

public class BloodBank {
    private int bankId;
    private String bankName;
    private String city;
    private String contact;

    public BloodBank() {}

    public BloodBank(int bankId, String bankName, String city, String contact) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.city = city;
        this.contact = contact;
    }

    public int getBankId() { return bankId; }
    public String getBankName() { return bankName; }
    public String getCity() { return city; }
    public String getContact() { return contact; }
}
