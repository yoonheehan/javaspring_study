package com.example.demo.dto.user.request;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class UserCreateRequest {

    private Long id;

    private String name;

    private String email;

}
