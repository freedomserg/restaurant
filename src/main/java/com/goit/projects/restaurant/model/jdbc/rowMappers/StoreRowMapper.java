package com.goit.projects.restaurant.model.jdbc.rowMappers;

import com.goit.projects.restaurant.model.entity.Store;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreRowMapper implements RowMapper<Store> {

    @Override
    public Store mapRow(ResultSet resultSet, int i) throws SQLException {
        Store store = new Store();
        store.setIngredientId(resultSet.getInt("ingredient_id"));
        store.setMinRequiredQuantity(resultSet.getInt("min_required_quantity"));
        store.setQuantity(resultSet.getInt("quantity"));
        return store;
    }
}
