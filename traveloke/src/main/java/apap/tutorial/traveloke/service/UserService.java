package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    public String encrypt(String password);
    UserModel getUserByUsername(String username);
    void userUpdatedPassword(UserModel user, String passBaru);
    List<UserModel> getListUser();
}