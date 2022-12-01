package com.caiotfernandes.workshopmongo.services;

import com.caiotfernandes.workshopmongo.domain.Post;
import com.caiotfernandes.workshopmongo.repositories.PostRepository;
import com.caiotfernandes.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findBId(String id) {
        Optional<Post> opt = repository.findById(id);
        return opt.orElseThrow(() ->
                new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
