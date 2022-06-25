package com.example.comsumerApp.modeller.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserManagementController {

    private final UserService userService;

    @GetMapping
//    @PreAuthorize("hasAnyRole('CUSTOMER, MODERATOR, USER')")
    public List<User> getUsers() {
        return userService.getUsers();
    }
}
