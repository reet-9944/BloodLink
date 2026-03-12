package com.bloodlink.dao;

import com.bloodlink.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BloodBankDAO {

    public boolean addBloodBank(String bankName, String city, String contact) {
        String sql = "INSERT INTO blood_banks(bank_name, city, contact) VALUES(?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, bankName);
            ps.setString(2, city);
            ps.setString(3, contact);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error addBloodBank: " + e.getMessage());
            return false;
        }
    }
}
