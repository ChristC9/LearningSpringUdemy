package com.chriscode.todo.dao;

import com.chriscode.todo.entity.Roles;

public interface RoleDao {

    public Roles findRoleByName(String theRoleName);

}
