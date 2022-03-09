package com.example.TravelGuide.repo;

import com.example.TravelGuide.models.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {

    Optional<UsersModel> findByLoginAndPassword (String login, String password);

    //Check if user is Present
    Optional<UsersModel> findFirstByLogin (String login);

}
