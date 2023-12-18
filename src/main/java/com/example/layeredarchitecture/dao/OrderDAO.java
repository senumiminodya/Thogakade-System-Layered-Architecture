package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;

public interface OrderDAO {
    public String generateNewId() throws SQLException, ClassNotFoundException;

    public boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
}
