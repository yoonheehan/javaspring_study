package com.example.demo.dto.user.response;


import com.example.demo.enitity.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class UserResponse {

    private final Long id;

    private final String name;

    private final String email;

    public static UserResponse fromEntity(User user){
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }
}
