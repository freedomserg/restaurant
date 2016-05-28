package com.goit.projects.restaurant.model.jdbc;

import com.goit.projects.restaurant.model.Dish;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishRowMapper implements RowMapper<Dish> {

    @Override
    public Dish mapRow(ResultSet resultSet, int i) throws SQLException {
        Dish dish = new Dish();
        dish.setDish_id(resultSet.getInt("dish_id"));
        dish.setDish_name(resultSet.getString("dish_name"));
        dish.setCategory_id(resultSet.getInt("category_id"));
        dish.setPrice(resultSet.getDouble("price"));
        dish.setWeight(resultSet.getInt("weight"));
        return dish;
    }
}
