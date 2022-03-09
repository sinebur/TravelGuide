package com.example.TravelGuide.service;

import com.example.TravelGuide.models.UsersModel;
import com.example.TravelGuide.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public UsersModel registerUser (String login, String password, String email){
        if (login == null || password == null) {
            return null;
        } else {
            if(usersRepository.findFirstByLogin(login).isPresent()){
                System.out.println("Duplicate login"); // Check if user logged-in
                return null;
            }
            UsersModel usersModel = new UsersModel();
            usersModel.setLogin(login);
            usersModel.setPassword(password);
            usersModel.setEmail(email);
            usersRepository.save(usersModel);
            return usersRepository.save(usersModel);
        }
    }

    public UsersModel authenticate (String login, String password){
        return usersRepository.findByLoginAndPassword(login, password).orElse(null);
    }
}
