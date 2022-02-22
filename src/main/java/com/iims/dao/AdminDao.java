package com.iims.dao;

import com.iims.model.Admin;

import java.sql.SQLException;

public interface AdminDao {
    Admin findOne(String username, String password) throws SQLException, ClassNotFoundException;
}
