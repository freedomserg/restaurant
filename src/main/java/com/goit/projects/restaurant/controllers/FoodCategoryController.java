package com.goit.projects.restaurant.controllers;

import com.goit.projects.restaurant.model.FoodCategory;
import com.goit.projects.restaurant.model.jdbc.JdbcFoodCategoryDAO;
import org.springframework.transaction.annotation.Transactional;

public class FoodCategoryController {

    private JdbcFoodCategoryDAO jdbcFoodCategoryDAO;

    public void setJdbcFoodCategoryDAO(JdbcFoodCategoryDAO jdbcFoodCategoryDAO) {
        this.jdbcFoodCategoryDAO = jdbcFoodCategoryDAO;
    }

    @Transactional
    public void addCategory(FoodCategory newCategory) {
        jdbcFoodCategoryDAO.saveCategory(newCategory);
    }
}
