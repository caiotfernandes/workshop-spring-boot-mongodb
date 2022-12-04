package com.caiotfernandes.workshopmongo.services;

import com.caiotfernandes.workshopmongo.ApplicationConfigTest;
import com.caiotfernandes.workshopmongo.domain.Post;
import com.caiotfernandes.workshopmongo.repositories.PostRepository;
import com.caiotfernandes.workshopmongo.services.exception.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("PostServiceTest")
class PostServiceTest extends ApplicationConfigTest {

    @Autowired
    PostService postService;
    @MockBean
    PostRepository repository;

    @BeforeEach
    public void setUp() {
    }

    @Test
    void findById_AssertNotNull() {
        Post postMock = mock(Post.class);
        Optional<Post> optional = Optional.of(postMock);
        when(repository.findById(anyString())).thenReturn(optional);
        assertNotNull(postService.findById(""));
    }

    @Test
    void findById_AssertThrowsObjectNotFoundException() {
        Optional<Post> optional = Optional.empty();
        when(repository.findById(anyString())).thenReturn(optional);

        Exception exception = assertThrows(ObjectNotFoundException.class, () -> {
            postService.findById("");
        });

        assertEquals("Objeto não encontrado", exception.getMessage());
    }

    @Test
    void findByTitle_AssertNotNull() {
        List<Post> listMock = Collections.emptyList();
        when(repository.searchTitle(anyString())).thenReturn(listMock);

        assertNotNull(postService.findByTitle(""));
    }

    @Test
    void fullSearch_AssertNotNull() {
        List<Post> listMock = Collections.emptyList();
        when(repository.fullSearch(anyString(),
                    ArgumentMatchers.any(Date.class),
                    ArgumentMatchers.any(Date.class)))
                .thenReturn(listMock);
        assertNotNull(postService.fullSearch("", new Date(), new Date()));
    }
}