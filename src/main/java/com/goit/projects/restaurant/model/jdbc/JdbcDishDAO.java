package com.goit.projects.restaurant.model.jdbc;

import com.goit.projects.restaurant.model.entity.Dish;
import com.goit.projects.restaurant.model.dao.DishDAO;
import com.goit.projects.restaurant.model.entity.Ingredient;
import com.goit.projects.restaurant.model.jdbc.rowMappers.DishRowMapper;
import com.goit.projects.restaurant.model.jdbc.rowMappers.IngredientRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class JdbcDishDAO implements DishDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveDish(Dish newDish) {
        String query = "INSERT INTO dish (category_id, dish_name, price, weight) " +
                "VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(query, newDish.getCategory_id(), newDish.getDish_name(),
                newDish.getPrice(), newDish.getWeight());
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeDishById(int id) {
        String removeFromDishIngredientsQuery = "DELETE FROM dish_ingredients " +
                                                    "WHERE dish_id = ?";
        jdbcTemplate.update(removeFromDishIngredientsQuery, id);
        String removeFromDishQuery = "DELETE FROM dish WHERE dish_id = ?";
        jdbcTemplate.update(removeFromDishQuery, id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeDishByName(String name) {
        String removeFromDishIngredientsQuery = "DELETE FROM dish_ingredients " +
                                                    "WHERE dish_id = " +
                                                        "(SELECT dish_id FROM dish " +
                                                            "WHERE dish_name = ?)";
        jdbcTemplate.update(removeFromDishIngredientsQuery, name);
        String removeFromDishQuery = "DELETE FROM dish WHERE dish_name = ?";
        jdbcTemplate.update(removeFromDishQuery, name);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Dish loadByName(String dishName) {
        String query = "SELECT * FROM dish WHERE dish_name = ?";
        return jdbcTemplate.queryForObject(query, new DishRowMapper(), dishName);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Dish loadById(int id) {
        String query = "SELECT * FROM dish WHERE dish_id = ?";
        return jdbcTemplate.queryForObject(query, new DishRowMapper(), id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Ingredient> loadIngredientsByDishName(String dishName) {
        String query = "SELECT * FROM ingredient " +
                            "WHERE ingredient.ingredient_id IN (" +
                                "SELECT ingredient_id FROM dish_ingredients " +
                                    "INNER JOIN dish " +
                                        "ON dish_ingredients.dish_id = dish.dish_id " +
                                            "AND dish.dish_name = ?" +
                                ")";
        return jdbcTemplate.query(query, new IngredientRowMapper(), dishName);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Dish> findAll() {
        String query = "SELECT * FROM dish";
        return jdbcTemplate.query(query, new DishRowMapper());
    }
}
