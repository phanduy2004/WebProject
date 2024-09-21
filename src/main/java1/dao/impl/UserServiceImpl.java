package dao.impl;

import config.ketnoidb;
import dao.IUserDao;
import dao.IUserService;
import model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements IUserService {

    IUserDao userDao = new UserDaoImpl();

    @Override
    public UserModel login(String username, String password) {
        UserModel user = this.findByUserModel(username);
        if (user!=null && password.equals(user.getPassword())){
            return user;
        }
        return null;
    }

    @Override
    public UserModel findByUserModel(String username) {
        String sql = "select * from inforuser where name = ?";
        UserModel user = null;

        try {
            Connection conn = ketnoidb.getDatabaseConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
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

    @Override
    public UserModel createUser(UserModel user) {
        String sql = "INSERT INTO inforuser (name, email, password, fullName, image, roleid, phone, createDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = ketnoidb.getDatabaseConnection();
            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getFullname()); // Assuming you have a getter for image
            ps.setString(5, user.getImage());
            ps.setInt(6, user.getRoleid());
            ps.setString(7, user.getPhone());

            // Convert datetimecurrent to java.sql.Date
            java.util.Date utilDate = new java.util.Date(); // Replace with your actual date
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            ps.setDate(8, sqlDate);

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }



}
