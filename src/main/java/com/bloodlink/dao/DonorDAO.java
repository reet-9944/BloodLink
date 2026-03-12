package com.bloodlink.dao;

import com.bloodlink.model.Donor;
import com.bloodlink.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DonorDAO {

    public boolean addDonor(String name, String bloodGroup, String phone, String city, String area, String lastDonationDate, boolean availability) {
        String sql = "INSERT INTO donors(name,blood_group,phone,city,area,last_donation_date,availability) VALUES(?,?,?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, bloodGroup);
            ps.setString(3, phone);
            ps.setString(4, city);
            ps.setString(5, area);

            if (lastDonationDate == null || lastDonationDate.trim().isEmpty()) {
                ps.setDate(6, null);
            } else {
                ps.setDate(6, java.sql.Date.valueOf(lastDonationDate));
            }

            ps.setBoolean(7, availability);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error addDonor: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Donor> getAvailableDonorsByBloodAndCity(String bloodGroup, String city) {
        ArrayList<Donor> list = new ArrayList<>();
        String sql = "SELECT * FROM donors WHERE blood_group=? AND city=? AND availability=TRUE";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, bloodGroup);
            ps.setString(2, city);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Donor(
                        rs.getInt("donor_id"),
                        rs.getString("name"),
                        rs.getString("blood_group"),
                        rs.getString("phone"),
                        rs.getString("city"),
                        rs.getString("area"),
                        rs.getDate("last_donation_date"),
                        rs.getBoolean("availability")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error getAvailableDonorsByBloodAndCity: " + e.getMessage());
        }
        return list;
    }
}
