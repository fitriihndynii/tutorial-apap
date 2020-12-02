package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user){
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public UserModel getUserByUsername(String username){
        return userDb.findByUsername(username);
    }

    @Override
    public void userUpdatedPassword(UserModel user, String passBaru){
        String encodedPassword = encrypt(passBaru);
        user.setPassword(encodedPassword);
        userDb.save(user);
    }

    @Override
    public List<UserModel> getListUser(){
        return userDb.findAll();
    }
}