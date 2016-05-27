package com.goit.projects.restaurant.model.jdbc;

import com.goit.projects.restaurant.model.FoodCategory;
import com.goit.projects.restaurant.model.FoodCategoryDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class JdbcFoodCategoryDAO implements FoodCategoryDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveCategory(FoodCategory newCategory) {
        String query = "INSERT INTO food_categories (category_name)" +
                "VALUES (?)";
        jdbcTemplate.update(query, newCategory.getCategory_name());
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeCategoryById(int id) {
        String query = "DELETE FROM food_categories WHERE category_id = ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void removeCategoryByName(String name) {
        String query = "DELETE FROM food_categories WHERE category_name = ?";
        jdbcTemplate.update(query, name);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public FoodCategory loadById(int id) {
        String query = "SELECT * FROM food_categories WHERE category_id = ?";
        return jdbcTemplate.queryForObject(query, new FoodCategoryRowMapper(), id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public FoodCategory loadByName(String name) {
        String query = "SELECT * FROM food_categories WHERE category_name = ?";
        return jdbcTemplate.queryForObject(query, new FoodCategoryRowMapper(), name);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<FoodCategory> findAll() {
        String query = "SELECT * FROM food_categories";
        return jdbcTemplate.query(query, new FoodCategoryRowMapper());
    }
}
