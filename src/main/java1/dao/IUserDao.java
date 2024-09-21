package dao;

import model.UserModel;

public interface IUserDao {
    UserModel findByUsername(String username);
    UserModel findByEmail(String email);
}
