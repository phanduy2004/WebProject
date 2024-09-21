package dao;

import model.UserModel;

public interface IUserService {
    UserModel login(String username, String password);

    UserModel findByUserModel(String username);

    UserModel findByEmail(String email);

    UserModel createUser(UserModel user);

}
