package com.bloodlink.dao;

import com.bloodlink.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StockDAO {

    public boolean addOrUpdateStock(int bankId, String bloodGroup, int units) {
        String checkSql = "SELECT stock_id FROM blood_stock WHERE bank_id=? AND blood_group=?";
        String insertSql = "INSERT INTO blood_stock(bank_id,blood_group,units_available) VALUES(?,?,?)";
        String updateSql = "UPDATE blood_stock SET units_available=? WHERE bank_id=? AND blood_group=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement checkPs = con.prepareStatement(checkSql)) {

            checkPs.setInt(1, bankId);
            checkPs.setString(2, bloodGroup);

            ResultSet rs = checkPs.executeQuery();
            if (rs.next()) {
                try (PreparedStatement up = con.prepareStatement(updateSql)) {
                    up.setInt(1, units);
                    up.setInt(2, bankId);
                    up.setString(3, bloodGroup);
                    return up.executeUpdate() > 0;
                }
            } else {
                try (PreparedStatement ins = con.prepareStatement(insertSql)) {
                    ins.setInt(1, bankId);
                    ins.setString(2, bloodGroup);
                    ins.setInt(3, units);
                    return ins.executeUpdate() > 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Error addOrUpdateStock: " + e.getMessage());
            return false;
        }
    }

    public void viewStockByCityAndGroup(String city, String bloodGroup) {
        String sql = """
                SELECT b.bank_name, b.city, s.blood_group, s.units_available, b.contact
                FROM blood_stock s
                JOIN blood_banks b ON s.bank_id = b.bank_id
                WHERE b.city=? AND s.blood_group=? AND s.units_available > 0
                """;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, city);
            ps.setString(2, bloodGroup);

            ResultSet rs = ps.executeQuery();
            System.out.println("\nAvailable Blood Banks:");
            int found = 0;
            while (rs.next()) {
                found++;
                System.out.println(found + ") " + rs.getString("bank_name") +
                        " | Units: " + rs.getInt("units_available") +
                        " | Contact: " + rs.getString("contact"));
            }
            if (found == 0) System.out.println("No stock found in this city for " + bloodGroup);
        } catch (Exception e) {
            System.out.println("Error viewStockByCityAndGroup: " + e.getMessage());
        }
    }
}
