package com.bloodlink.dao;

import com.bloodlink.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RequestDAO {

    public boolean createRequest(String patientName, String bloodGroup, int unitsNeeded, String city, String emergencyLevel) {
        String sql = "INSERT INTO blood_requests(patient_name,blood_group,units_needed,city,emergency_level,status) VALUES(?,?,?,?,?,'OPEN')";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patientName);
            ps.setString(2, bloodGroup);
            ps.setInt(3, unitsNeeded);
            ps.setString(4, city);
            ps.setString(5, emergencyLevel);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error createRequest: " + e.getMessage());
            return false;
        }
    }
}
