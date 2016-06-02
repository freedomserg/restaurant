package com.goit.projects.restaurant.model.jdbc.rowMappers;

import com.goit.projects.restaurant.model.entity.FoodCategory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FoodCategoryRowMapper implements RowMapper<FoodCategory> {

    @Override
    public FoodCategory mapRow(ResultSet resultSet, int i) throws SQLException {
        FoodCategory category = new FoodCategory();
        category.setCategory_id(resultSet.getInt("category_id"));
        category.setCategory_name(resultSet.getString("category_name"));
        return category;
    }
}
