package com.caiotfernandes.workshopmongo.resources;

import com.caiotfernandes.workshopmongo.ApplicationConfigTest;
import com.caiotfernandes.workshopmongo.domain.User;
import com.caiotfernandes.workshopmongo.dto.UserDTO;
import com.caiotfernandes.workshopmongo.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserResourceTest extends ApplicationConfigTest {

    @MockBean
    private UserService service;

    @Autowired
    private MockMvc mockMvc;

    private static final String PATH = "/users";

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void insert() throws Exception {

        UserDTO dto = UserDTO.builder().build();
        String json = new ObjectMapper().writeValueAsString(dto);

        User userMock = mock(User.class);
        when(userMock.getId()).thenReturn("1");

        when(service.fromDTO(any(UserDTO.class))).thenReturn(userMock);
        when(service.insert(any(User.class))).thenReturn(userMock);

        mockMvc.perform(MockMvcRequestBuilders.post(PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        verify(service, times(1)).insert(any(User.class));
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void findPosts() {
    }
}