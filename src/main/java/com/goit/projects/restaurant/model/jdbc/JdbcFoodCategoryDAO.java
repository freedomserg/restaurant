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
    public void removeCategory(FoodCategory category) {

    }

    @Override
    public FoodCategory loadByName(String name) {
        return null;
    }

    @Override
    public List<FoodCategory> findAll() {
        return null;
    }
}
