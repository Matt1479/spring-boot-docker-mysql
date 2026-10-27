package com.matt1479.springbootdockermysql.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.matt1479.springbootdockermysql.users.dto.UserResponse;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(String name, String email) {
        User user = new User(name, email);
        userRepository.save(user);
        return toResponse(user);
    }

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "User not found"));

        return toResponse(user);
    }

    public List<UserResponse> getAllUsers() {
        List<UserResponse> users = new ArrayList<>();

        userRepository.findAll()
            .forEach((user) -> users.add(toResponse(user)));

        return users;
    }

    public UserResponse updateUser(Long id, String name, String email) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "User not found"));
                
        user.setName(name);
        user.setEmail(email);

        User updatedUser = userRepository.save(user);
        return toResponse(updatedUser);
    }

    public void deleteUserById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "User not found");
        }
        
        userRepository.deleteById(id);
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

}
