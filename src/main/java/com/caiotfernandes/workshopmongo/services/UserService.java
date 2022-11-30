package com.caiotfernandes.workshopmongo.services;

import com.caiotfernandes.workshopmongo.domain.User;
import com.caiotfernandes.workshopmongo.repositories.UserRepository;
import com.caiotfernandes.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findBId(String id) {
        Optional<User> optUser = repository.findById(id);
        return optUser.orElseThrow(() ->
                new ObjectNotFoundException("Objeto não encontrado"));
    }

}
