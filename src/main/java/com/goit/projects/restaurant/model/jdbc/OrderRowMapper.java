package com.goit.projects.restaurant.model.jdbc;

import com.goit.projects.restaurant.model.entity.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        order.setOrder_id(resultSet.getInt("order_id"));
        order.setState(resultSet.getString("order_state"));
        order.setTable_number(resultSet.getInt("table_number"));
        order.setWaiter_id(resultSet.getInt("waiter_id"));
        order.setOrder_date(new Date(resultSet.getDate("order_date").getTime()));
        return order;
    }
}
