package com.example.demo.service.user;

import com.example.demo.dto.user.request.UserCreateRequest;
import com.example.demo.dto.user.response.UserResponse;

import com.example.demo.enitity.user.User;
import com.example.demo.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserResponse> getUsers() {
        List<User> users =  userRepository.findAll();
        return users.stream().map(UserResponse::fromEntity).collect(Collectors.toList());
    }

    public UserResponse getUser(Long id){
        User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return UserResponse.fromEntity(user);
    }

    public UserResponse createUser(UserCreateRequest request) {
        User user =  userRepository.save(new User(request.getName(), request.getEmail()));
        return UserResponse.fromEntity(user);
    }

    public UserResponse updateUser(UserCreateRequest request, Long id){
        User user = userRepository.findById(id).orElseThrow(IllegalAccessError::new);
        user.updateUser(request.getName(), request.getEmail());
        userRepository.save(user);
        return UserResponse.fromEntity(user);
    }

    public UserResponse deleteUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow(IllegalAccessError::new);
        userRepository.delete(user);
        return UserResponse.fromEntity(user);
    }
}
