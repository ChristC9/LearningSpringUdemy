package com.chriscode.todo.dao;

import com.chriscode.todo.entity.User;

public interface UserDao {

    User findUserByUsername(String userName);

}
