package dao.impl;

import config.ketnoidb;
import dao.IUserDao;
import model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {

    public static void main(String[] args) {
        try {
            UserDaoImpl userDao = new UserDaoImpl();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserModel findByUsername(String username) {
        String sql = "select * from users where name = ?";
        try (Connection conn = ketnoidb.getDatabaseConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    UserModel user = new UserModel();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setEmail(rs.getString("email"));
                    user.setFullname(rs.getString("fullname"));
                    user.setPassword(rs.getString("password"));
                    user.setPhone(rs.getString("phone"));
                    user.setImage(rs.getString("image"));
                    user.setRoleid(rs.getInt("roleid"));

                    // In ra dữ liệu để kiểm tra
                    System.out.println("User ID: " + user.getId());
                    System.out.println("User Name: " + user.getName());
                    System.out.println("User Email: " + user.getEmail());

                    return user;
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi tìm người dùng theo tên: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserModel findByEmail(String email) {
        String sql = "select * from inforuser where email = ?";
        UserModel user = null;

        try {
            Connection conn = ketnoidb.getDatabaseConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new UserModel();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setImage(rs.getString("image"));
                user.setFullname(rs.getString("fullName"));
                user.setRoleid(rs.getInt("roleid"));
                user.setPhone(rs.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

}
