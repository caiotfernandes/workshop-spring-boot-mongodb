package com.caiotfernandes.workshopmongo.resources;

import com.caiotfernandes.workshopmongo.domain.Post;
import com.caiotfernandes.workshopmongo.domain.User;
import com.caiotfernandes.workshopmongo.dto.UserDTO;
import com.caiotfernandes.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream()
                .map(x -> UserDTO.fromUser(x))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = service.findBId(id);
        return ResponseEntity.ok().body(UserDTO.fromUser(user));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO objDto) {
        User user = service.fromDTO(objDto);
        user = service.insert(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDTO objDto) {
        User user = service.fromDTO(objDto);
        user.setId(id);
        service.update(user);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User user = service.findBId(id);
        return ResponseEntity.ok().body(user.getPosts());
    }

}
