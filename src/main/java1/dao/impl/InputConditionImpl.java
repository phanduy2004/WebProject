package dao.impl;

import config.ketnoidb;
import dao.InputCondition;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InputConditionImpl implements InputCondition {
    @Override
    public boolean checkEmail(String email) {
        String sql = "SELECT COUNT(*) FROM inforuser WHERE email = ?";
        try (Connection conn = ketnoidb.getDatabaseConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkUsername(String username) {
        String sql = "SELECT COUNT(*) FROM inforuser WHERE name = ?";
        try (Connection conn = ketnoidb.getDatabaseConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }


}
