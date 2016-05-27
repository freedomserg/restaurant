package com.goit.projects.restaurant.controllers;

import com.goit.projects.restaurant.model.FoodCategory;
import com.goit.projects.restaurant.model.jdbc.JdbcFoodCategoryDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class FoodCategoryController {

    private JdbcFoodCategoryDAO jdbcFoodCategoryDAO;

    public void setJdbcFoodCategoryDAO(JdbcFoodCategoryDAO jdbcFoodCategoryDAO) {
        this.jdbcFoodCategoryDAO = jdbcFoodCategoryDAO;
    }

    @Transactional
    public void addCategory(FoodCategory newCategory) {
        jdbcFoodCategoryDAO.saveCategory(newCategory);
    }

    @Transactional
    public void deleteCategoryById(int id) {
        jdbcFoodCategoryDAO.removeCategoryById(id);
    }

    @Transactional
    public void deleteCategoryByName(String name) {
        jdbcFoodCategoryDAO.removeCategoryByName(name);
    }

    @Transactional
    public FoodCategory getCategoryById(int id) {
        return jdbcFoodCategoryDAO.loadById(id);
    }

    @Transactional
    public FoodCategory getCategoryByName(String name) {
        return jdbcFoodCategoryDAO.loadByName(name);
    }

    @Transactional
    public List<FoodCategory> getAll() {
        return jdbcFoodCategoryDAO.findAll();
    }
}
