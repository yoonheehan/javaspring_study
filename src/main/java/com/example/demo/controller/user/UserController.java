package com.example.demo.controller.user;

import com.example.demo.dto.user.request.UserCreateRequest;
import com.example.demo.dto.user.response.UserResponse;
import com.example.demo.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserResponse getUsers(@PathVariable(name = "id") Long id){
        return userService.getUser(id);
    }

    @PostMapping("")
    public UserResponse createUser(@RequestBody UserCreateRequest userCreateRequest){
        return userService.createUser(userCreateRequest);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@RequestBody UserCreateRequest userCreateRequest, @PathVariable(name="id") Long id){
        return userService.updateUser(userCreateRequest, id);
    }

    @DeleteMapping("/{id}")
    public UserResponse deleteUser(@PathVariable(name="id") Long id) {
        return userService.deleteUser(id);
    }
}
