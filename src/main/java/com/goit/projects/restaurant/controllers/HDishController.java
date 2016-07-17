package com.goit.projects.restaurant.controllers;

import com.goit.projects.restaurant.model.dao.DishDAO;
import com.goit.projects.restaurant.model.entity.Dish;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

public class HDishController {

    private DishDAO dishDAO;
    private HFoodCategoryController foodCategoryController;


    public void setDishDAO(DishDAO dishDAO) {
        this.dishDAO = dishDAO;
    }

    public void setFoodCategoryController(HFoodCategoryController foodCategoryController) {
        this.foodCategoryController = foodCategoryController;
    }

    @Transactional
    public void createDish() {
        Dish dish = new Dish();
        dish.setDish_name("Fresh salad");
        dish.setCategory(foodCategoryController.getCategoryByName("salad"));
        dish.setWeight(200);
        dish.setPrice(1.5);

        Set<Dish> dishes = new HashSet<>(dishDAO.findAll());
        if (!dishes.contains(dish)) {
            dishDAO.saveDish(dish);
        }
    }

    @Transactional
    public Dish getByName(String name) {
        return dishDAO.loadByName(name);
    }
}
