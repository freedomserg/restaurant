package com.goit.projects.restaurant.controllers;

import com.goit.projects.restaurant.model.Ingredient;
import com.goit.projects.restaurant.model.IngredientDAO;
import com.goit.projects.restaurant.model.jdbc.JdbcIngredientDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class IngredientController {

    private IngredientDAO ingredientDAO;

    public void setIngredientDAO(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    @Transactional
    public void addIngredient(Ingredient newIngredient) {
        ingredientDAO.saveIngredient(newIngredient);
    }

    @Transactional
    public void deleteById(int id) {
        ingredientDAO.removeById(id);
    }

    @Transactional
    public void deleteByName(String name) {
        ingredientDAO.removeByName(name);
    }

    @Transactional
    public Ingredient getById(int id) {
        return ingredientDAO.loadById(id);
    }

    @Transactional
    public Ingredient getByName(String name) {
        return ingredientDAO.loadByName(name);
    }

    @Transactional
    public List<Ingredient> getAll() {
        return ingredientDAO.findAll();
    }
}
