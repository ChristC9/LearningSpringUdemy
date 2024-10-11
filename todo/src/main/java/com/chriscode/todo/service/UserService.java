package com.chriscode.todo.service;

import com.chriscode.todo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findbyUserName(String userName);

}
