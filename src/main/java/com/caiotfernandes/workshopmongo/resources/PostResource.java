package com.caiotfernandes.workshopmongo.resources;

import com.caiotfernandes.workshopmongo.domain.Post;
import com.caiotfernandes.workshopmongo.domain.User;
import com.caiotfernandes.workshopmongo.dto.UserDTO;
import com.caiotfernandes.workshopmongo.services.PostService;
import com.caiotfernandes.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findBId(id);
        return ResponseEntity.ok().body(obj);
    }

}
