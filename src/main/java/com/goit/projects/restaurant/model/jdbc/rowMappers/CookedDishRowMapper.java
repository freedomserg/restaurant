package com.goit.projects.restaurant.model.jdbc.rowMappers;

import com.goit.projects.restaurant.model.entity.CookedDish;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CookedDishRowMapper implements RowMapper<CookedDish> {

    @Override
    public CookedDish mapRow(ResultSet resultSet, int i) throws SQLException {
        CookedDish cookedDish = new CookedDish();
        cookedDish.setCookedDish_id(resultSet.getInt("cooked_dish_id"));
        cookedDish.setDish_id(resultSet.getInt("dish_id"));
        cookedDish.setCook_id(resultSet.getInt("cook_id"));
        cookedDish.setOrder_id(resultSet.getInt("order_id"));
        cookedDish.setPreparation_date(new Date(resultSet.getDate("preparation_date").getTime()));
        return cookedDish;
    }
}
