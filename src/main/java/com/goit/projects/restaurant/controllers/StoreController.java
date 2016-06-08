package com.goit.projects.restaurant.controllers;

import com.goit.projects.restaurant.model.dao.StoreDAO;
import com.goit.projects.restaurant.model.entity.Store;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StoreController {

    private StoreDAO storeDAO;

    public void setStoreDAO(StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }

    @Transactional
    public void addIngredient(int ingredientId, int minRequiredQuantity, int quantity) {
        storeDAO.saveIngredient(ingredientId, minRequiredQuantity, quantity);
    }

    @Transactional
    public void deleteIngredient(int ingredientId) {
        storeDAO.removeIngredient(ingredientId);
    }

    @Transactional
    public void changeIngredientQuantity(int ingredientId, int newQuantity) {
        storeDAO.updateIngredientQuantity(ingredientId, newQuantity);
    }

    @Transactional
    public Store getIngredientByName(String ingredientName) {
        return storeDAO.loadByIngredientName(ingredientName);
    }

    @Transactional
    public List<Store> getAllIngredients() {
        return storeDAO.findAllIngredients();
    }

    @Transactional
    public List<Store> getIngredientsAreBeingDecreased() {
        return storeDAO.findIngredientsAreBeingDecreased();
    }
}
