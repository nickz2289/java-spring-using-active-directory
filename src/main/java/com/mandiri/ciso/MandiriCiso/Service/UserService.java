package com.mandiri.ciso.MandiriCiso.Service;

import com.mandiri.ciso.MandiriCiso.Model.User;
import com.mandiri.ciso.MandiriCiso.Repository.UserRepo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getList(){
        return userRepo.findAll();
    }

    public User getUser(){
        return new User(
                "Mira",
                "mira"
        );
    }

    public User newUser(User user){
        return userRepo.save(user);
    }
}
