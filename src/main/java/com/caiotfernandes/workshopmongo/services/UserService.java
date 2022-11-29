package com.caiotfernandes.workshopmongo.services;

import com.caiotfernandes.workshopmongo.domain.User;
import com.caiotfernandes.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

}
