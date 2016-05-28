package com.goit.projects.restaurant.model.jdbc;

import com.goit.projects.restaurant.model.entity.Ingredient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientRowMapper implements RowMapper<Ingredient> {

    @Override
    public Ingredient mapRow(ResultSet resultSet, int i) throws SQLException {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredient_id(resultSet.getInt("ingredient_id"));
        ingredient.setIngredient_name(resultSet.getString("ingredient_name"));
        return ingredient;
    }
}
