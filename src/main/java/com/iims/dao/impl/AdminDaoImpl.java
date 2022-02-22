package com.iims.dao.impl;

import com.iims.connection.ConnectionFactory;
import com.iims.dao.AdminDao;
import com.iims.model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    @Override
    public Admin findOne(String username, String password) throws SQLException, ClassNotFoundException{
        final String SqlQuery = "SELECT * FROM admin WHERE username = ? AND password = ?";
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery);

        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        Admin admin = null;

        while (resultSet.next()) {
            admin = new Admin();
            admin.setId(resultSet.getInt("id"));
            admin.setFirst_name(resultSet.getString("first_name"));
            admin.setLast_name(resultSet.getString("last_name"));
            admin.setUsername(resultSet.getString("username"));
            admin.setPassword(resultSet.getString("password"));
        }

        return admin;
    }
}
