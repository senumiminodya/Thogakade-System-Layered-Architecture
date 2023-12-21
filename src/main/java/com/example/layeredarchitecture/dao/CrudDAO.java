package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> {
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    public boolean save(T dto) throws SQLException, ClassNotFoundException;

    public boolean update(T dto) throws SQLException, ClassNotFoundException;

    public boolean exist(String id) throws SQLException, ClassNotFoundException;

    public String generateNewId() throws SQLException, ClassNotFoundException;

    public int delete(String id) throws SQLException, ClassNotFoundException;

    public CustomerDTO search(String newValue) throws SQLException, ClassNotFoundException;
}
