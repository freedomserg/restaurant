package com.goit.projects.restaurant.controllers;

import com.goit.projects.restaurant.model.Ingredient;
import com.goit.projects.restaurant.model.jdbc.JdbcIngredientDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class IngredientController {

    private JdbcIngredientDAO jdbcIngredientDAO;

    public void setJdbcIngredientDAO(JdbcIngredientDAO jdbcIngredientDAO) {
        this.jdbcIngredientDAO = jdbcIngredientDAO;
    }

    @Transactional
    public void addIngredient(Ingredient newIngredient) {
        jdbcIngredientDAO.saveIngredient(newIngredient);
    }

    @Transactional
    public void deleteById(int id) {
        jdbcIngredientDAO.removeById(id);
    }

    @Transactional
    public void deleteByName(String name) {
        jdbcIngredientDAO.removeByName(name);
    }

    @Transactional
    public Ingredient getById(int id) {
        return jdbcIngredientDAO.loadById(id);
    }

    @Transactional
    public Ingredient getByName(String name) {
        return jdbcIngredientDAO.loadByName(name);
    }

    @Transactional
    public List<Ingredient> getAll() {
        return jdbcIngredientDAO.findAll();
    }
}
