package com.goit.projects.restaurant.model.dao;

import com.goit.projects.restaurant.model.entity.Ingredient;

import java.util.List;

public interface StoreDAO {

    void addIngredient(Ingredient newIngredient);

    void removeIngredient(Ingredient ingredient);

    void updateIngredientQuantity(Ingredient ingredient, int newQuantity);

    Ingredient loadByName(String ingredientName);

    List<Ingredient> findAll();

    List<Ingredient> findIsBeingDecreased();
}
