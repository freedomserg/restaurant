package com.goit.projects.restaurant.model.jdbc;

import com.goit.projects.restaurant.model.Dish;
import com.goit.projects.restaurant.model.DishDAO;
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
        String query = "DELETE FROM dish WHERE dish_id = ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeDishByName(String name) {
        String query = "DELETE FROM dish WHERE dish_name = ?";
        jdbcTemplate.update(query, name);
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
    public List<Dish> findAll() {
        String query = "SELECT * FROM dish";
        return jdbcTemplate.query(query, new DishRowMapper());
    }
}
