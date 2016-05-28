package com.goit.projects.restaurant.controllers;

import com.goit.projects.restaurant.model.FoodCategory;
import com.goit.projects.restaurant.model.FoodCategoryDAO;
import com.goit.projects.restaurant.model.jdbc.JdbcFoodCategoryDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class FoodCategoryController {

    private FoodCategoryDAO foodCategoryDAO;

    public void setFoodCategoryDAO(FoodCategoryDAO foodCategoryDAO) {
        this.foodCategoryDAO = foodCategoryDAO;
    }

    @Transactional
    public void addCategory(FoodCategory newCategory) {
        foodCategoryDAO.saveCategory(newCategory);
    }

    @Transactional
    public void deleteCategoryById(int id) {
        foodCategoryDAO.removeCategoryById(id);
    }

    @Transactional
    public void deleteCategoryByName(String name) {
        foodCategoryDAO.removeCategoryByName(name);
    }

    @Transactional
    public FoodCategory getCategoryById(int id) {
        return foodCategoryDAO.loadById(id);
    }

    @Transactional
    public FoodCategory getCategoryByName(String name) {
        return foodCategoryDAO.loadByName(name);
    }

    @Transactional
    public List<FoodCategory> getAll() {
        return foodCategoryDAO.findAll();
    }
}
