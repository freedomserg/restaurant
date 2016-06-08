package com.goit.projects.restaurant.model.jdbc;

import com.goit.projects.restaurant.model.dao.StoreDAO;
import com.goit.projects.restaurant.model.entity.Store;
import com.goit.projects.restaurant.model.jdbc.rowMappers.StoreRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class JdbcStoreDAO implements StoreDAO {

    public static final double QUANTITY_IS_BEING_DECREASED = 210;
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveIngredient(int ingredientId, int minRequiredQuantity, int quantity) {
        String query = "INSERT INTO store VALUES (?, ?, ?)";
        jdbcTemplate.update(query, ingredientId, quantity, minRequiredQuantity);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeIngredient(int ingredientId) {
        String query = "DELETE FROM store WHERE ingredient_id = ?";
        jdbcTemplate.update(query, ingredientId);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void updateIngredientQuantity(int ingredientId, int newQuantity) {
        String query = "UPDATE store SET quantity = ? WHERE ingredient_id = ?";
        jdbcTemplate.update(query, newQuantity, ingredientId);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Store loadByIngredientName(String ingredientName) {
        String query = "SELECT * FROM store " +
                            "INNER JOIN ingredient " +
                                "ON store.ingredient_id = ingredient.ingredient_id " +
                                    "AND ingredient_name = ?";
        return jdbcTemplate.queryForObject(query, new StoreRowMapper(), ingredientName);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Store> findAllIngredients() {
        String query = "SELECT * FROM store";
        return jdbcTemplate.query(query, new StoreRowMapper());
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Store> findIngredientsAreBeingDecreased() {
        String query = "SELECT * FROM store WHERE quantity < (min_required_quantity * ?)";
        return jdbcTemplate.query(query, new StoreRowMapper(), QUANTITY_IS_BEING_DECREASED / 100);
    }
}
