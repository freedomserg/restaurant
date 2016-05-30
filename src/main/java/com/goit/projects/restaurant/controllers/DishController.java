package com.goit.projects.restaurant.controllers;

import com.goit.projects.restaurant.model.entity.Dish;
import com.goit.projects.restaurant.model.dao.DishDAO;
import com.goit.projects.restaurant.model.entity.Ingredient;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class DishController {

    private DishDAO dishDAO;

    public void setDishDAO(DishDAO dishDAO) {
        this.dishDAO = dishDAO;
    }

    @Transactional
    public void add(Dish newDish) {
        dishDAO.saveDish(newDish);
    }

    @Transactional
    public void deleteById(int id) {
        dishDAO.removeDishById(id);
    }

    @Transactional
    public void deleteByName(String name) {
        dishDAO.removeDishByName(name);
    }

    @Transactional
    public Dish getById(int id) {
        return dishDAO.loadById(id);
    }

    @Transactional
    public Dish getByName(String name) {
        return dishDAO.loadByName(name);
    }

    @Transactional
    public void getIngredientsByDishName(String dishName) {
        List<Ingredient> ingredients = dishDAO.loadIngredientsByDishName(dishName);
        System.out.println(dishName + ":");
        ingredients.forEach(System.out::println);
    }

    @Transactional
    public List<Dish> getAll() {
        return dishDAO.findAll();
    }
}
