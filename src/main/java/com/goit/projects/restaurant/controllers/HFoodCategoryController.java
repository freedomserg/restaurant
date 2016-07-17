package com.goit.projects.restaurant.controllers;

import com.goit.projects.restaurant.model.dao.FoodCategoryDAO;
import com.goit.projects.restaurant.model.entity.FoodCategory;
import org.springframework.transaction.annotation.Transactional;

public class HFoodCategoryController {

    private FoodCategoryDAO foodCategoryDAO;

    public void setFoodCategoryDAO(FoodCategoryDAO foodCategoryDAO) {
        this.foodCategoryDAO = foodCategoryDAO;
    }

    @Transactional
    public FoodCategory getCategoryByName(String name) {
        return foodCategoryDAO.loadByName(name);
    }

    @Transactional
    public FoodCategory getCategoryById(int id) {
        return foodCategoryDAO.loadById(id);
    }
}
