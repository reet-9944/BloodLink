package com.bloodlink.model;

import java.sql.Date;

public class Donor {
    private int donorId;
    private String name;
    private String bloodGroup;
    private String phone;
    private String city;
    private String area;
    private Date lastDonationDate;
    private boolean availability;

    public Donor() {}

    public Donor(int donorId, String name, String bloodGroup, String phone, String city, String area, Date lastDonationDate, boolean availability) {
        this.donorId = donorId;
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.phone = phone;
        this.city = city;
        this.area = area;
        this.lastDonationDate = lastDonationDate;
        this.availability = availability;
    }

    public int getDonorId() { return donorId; }
    public String getName() { return name; }
    public String getBloodGroup() { return bloodGroup; }
    public String getPhone() { return phone; }
    public String getCity() { return city; }
    public String getArea() { return area; }
    public Date getLastDonationDate() { return lastDonationDate; }
    public boolean isAvailability() { return availability; }
}
