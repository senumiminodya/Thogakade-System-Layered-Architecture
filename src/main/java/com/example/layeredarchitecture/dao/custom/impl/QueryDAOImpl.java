package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.model.QueryDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public ArrayList<QueryDTO> query() throws SQLException, ClassNotFoundException {
        String sql = "SELECT Customer.id, Customer.name, Orders.oid, Orders.date " +
                "FROM Customer LEFT JOIN Orders ON Customer.id = Orders.customerID;";
        ResultSet rst = SQLUtil.execute(sql);
        ArrayList<QueryDTO> getAllQuery = new ArrayList<>();
        while (rst.next()) {
            //System.out.println(rst.getString(1) + " " + rst.getString(2) + " " + rst.getString(3) + " " + rst.getString(4));
            getAllQuery.add(new QueryDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)));
        }
        return getAllQuery;
    }

}
