package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();*/
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");
        ArrayList<ItemDTO> getAllItem=new ArrayList<>();
        while (rst.next()) {
            ItemDTO itemDTO=new ItemDTO(rst.getString("code"),rst.getString("description"),rst.getBigDecimal("unitPrice"),rst.getInt("qtyOnHand"));
            getAllItem.add(itemDTO);
        }
        return getAllItem;
    }

    @Override
    public int delete(String code) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
        pstm.setString(1, code);*/
        return SQLUtil.execute("DELETE FROM Item WHERE code=?", code);
    }

    @Override
    public CustomerDTO search(String newValue) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
        pstm.setString(1, itemDTO.getCode());
        pstm.setString(2, itemDTO.getDescription());
        pstm.setBigDecimal(3, itemDTO.getUnitPrice());
        pstm.setInt(4, itemDTO.getQtyOnHand());*/
        return SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", itemDTO.getCode(), itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQtyOnHand());
    }

    @Override
    public boolean update(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
        pstm.setString(1, itemDTO.getDescription());
        pstm.setBigDecimal(2, itemDTO.getUnitPrice());
        pstm.setInt(3, itemDTO.getQtyOnHand());
        pstm.setString(4, itemDTO.getCode());*/
        return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", itemDTO.getDescription(), itemDTO.getUnitPrice(), itemDTO.getQtyOnHand(), itemDTO.getCode());
    }

    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
        pstm.setString(1, code);*/
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item WHERE code=?", code);
        return rst.next();
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");*/
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String code = rst.getString("code");
            int newItemId = Integer.parseInt(code.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public ArrayList<ItemDTO> findItems(String newItemCode) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
        pstm.setString(1, newItemCode + "");*/
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code=?", newItemCode + "");
        ArrayList<ItemDTO> items = new ArrayList<>();

        while (rst.next()) {
            ItemDTO itemDTO = new ItemDTO(newItemCode + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
            items.add(itemDTO);
        }
        return items;
    }
}
