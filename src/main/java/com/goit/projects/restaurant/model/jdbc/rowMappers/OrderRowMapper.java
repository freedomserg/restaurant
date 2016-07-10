package com.goit.projects.restaurant.model.jdbc.rowMappers;

import com.goit.projects.restaurant.model.entity.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException {
        Order order = new Order();
        order.setOrderId(resultSet.getInt("order_id"));
        order.setState(resultSet.getString("order_state"));
        order.setTableNumber(resultSet.getInt("table_number"));
        order.setWaiterId(resultSet.getInt("waiter_id"));
        order.setOrderDate(new Date(resultSet.getDate("order_date").getTime()));
        return order;
    }
}
