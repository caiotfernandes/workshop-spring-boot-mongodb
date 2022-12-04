package com.caiotfernandes.workshopmongo.dto;

import com.caiotfernandes.workshopmongo.domain.User;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 2695609717163254747L;
    private String id;
    private String name;
    private String email;

    public static UserDTO fromUser(User user) {
        return builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
