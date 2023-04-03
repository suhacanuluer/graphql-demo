package com.suhacan.graphqldemo.controller;

import com.suhacan.graphqldemo.model.User;
import com.suhacan.graphqldemo.model.request.UserRequest;
import com.suhacan.graphqldemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @QueryMapping
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    User getUserById(@Argument Long id) {
        return userService.getUserById(id);
    }

    @MutationMapping
    User createUser(@Argument UserRequest request) {
        return userService.createUser(request);
    }

    @MutationMapping
    User updateUser(@Argument UserRequest request) {
        return userService.updateUser(request);
    }

    @MutationMapping
    Boolean deleteUser(@Argument Long id) {
        return userService.deleteUser(id);
    }
}
